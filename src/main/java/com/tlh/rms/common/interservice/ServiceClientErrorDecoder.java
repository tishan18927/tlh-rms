package com.tlh.rms.common.interservice;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.CharStreams;
import com.tlh.rms.common.error.ErrorResponse;
import com.tlh.rms.common.error.ErrorType;
import com.tlh.rms.common.error.ServiceException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class ServiceClientErrorDecoder implements ErrorDecoder {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceClientErrorDecoder.class);

    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {

        Reader reader = null;

        ErrorResponse exceptionMessage;
        try {
            reader = response.body().asReader(StandardCharsets.UTF_8);
            String result = IOUtils.toString(reader);
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            exceptionMessage = mapper.readValue(result, ErrorResponse.class);

        } catch (IOException e) {
            LOGGER.error(e.getLocalizedMessage());
            return new ServiceException(ErrorType.CONVERSION_FAILURE, e.getLocalizedMessage());

        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        switch (response.status()) {

            case 404:
                return new ServiceException(ErrorType.INTERSERVICE_ERROR, "Not Found!");

        }

        return new ServiceException(ErrorType.INTERSERVICE_ERROR, exceptionMessage.getMessage());
    }
}
