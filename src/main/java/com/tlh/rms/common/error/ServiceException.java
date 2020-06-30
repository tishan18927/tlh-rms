package com.tlh.rms.common.error;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceException extends RuntimeException {

    private ErrorType type;

    public ServiceException(ErrorType type) {
        super(type.getMessage());
        this.type = type;
    }

    public ServiceException(ErrorType type, String message) {
        super(message);
        this.type = type;
    }
}
