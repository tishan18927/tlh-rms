package com.tlh.rms.common.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvicer extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAdvicer.class);

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exception,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        LOGGER.error(exception.getMessage());
        ErrorType type = ErrorType.VALIDATION_FAILED;
        return new ResponseEntity<>(new ErrorResponse(request.getContextPath(), type.name(), type.getMessage(), exception.getMessage(), System.currentTimeMillis()), headers, status);
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(ServiceException exception, WebRequest request) {
        LOGGER.error(exception.getMessage());
        ErrorType type = exception.getType();
        return new ResponseEntity<>(new ErrorResponse(request.getContextPath(), type.name(), type.getMessage(), exception.getLocalizedMessage(), System.currentTimeMillis()), new HttpHeaders(), type.getStatus());
    }
}
