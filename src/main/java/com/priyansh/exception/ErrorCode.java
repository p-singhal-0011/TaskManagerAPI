package com.priyansh.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    TASK_NOT_FOUND(HttpStatus.NOT_FOUND, "Task not found"),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User not found"),
    EMAIL_ALREADY_EXISTS(HttpStatus.BAD_REQUEST, "Email already registered"),
    UNAUTHORIZED_ACTION(HttpStatus.FORBIDDEN, "You are not allowed to perform this action"),
    INVALID_CREDENTIALS(HttpStatus.UNAUTHORIZED, "Invalid email or password"),
    TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "Token expired. Please login again"),
    INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong");

    private final HttpStatus status;
    private final String message;

    ErrorCode(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}