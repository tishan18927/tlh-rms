package com.tlh.rms.common.error;

import org.springframework.http.HttpStatus;

public enum ErrorType {

    STRIPE_ERROR("Error on charging!", HttpStatus.SERVICE_UNAVAILABLE),
    VALIDATION_FAILED("Validation failed!", HttpStatus.BAD_REQUEST),
    ROOM_ALREADY_TAKEN("Room is already taken!", HttpStatus.CONFLICT),
    NO_ROOMS_AVAILABLE("All rooms are reserved!", HttpStatus.CONFLICT),
    INTERSERVICE_ERROR("Interservice call failure!", HttpStatus.INTERNAL_SERVER_ERROR),
    CONVERSION_FAILURE("Data conversion failure!", HttpStatus.INTERNAL_SERVER_ERROR)
    ;

    private String message;
    private HttpStatus status;

    public String getMessage() {
        return this.message;
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    private ErrorType(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
