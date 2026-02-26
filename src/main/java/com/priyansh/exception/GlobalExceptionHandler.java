package com.priyansh.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiErrorResponse> handleApiException(ApiException ex) {

        ErrorCode errorCode = ex.getErrorCode();

        ApiErrorResponse response = new ApiErrorResponse(
                errorCode.getStatus().value(),
                errorCode.getStatus().getReasonPhrase(),
                errorCode.getMessage()
        );

        return new ResponseEntity<>(response, errorCode.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleGeneralException(Exception ex) {

        ApiErrorResponse response = new ApiErrorResponse(
                500,
                "Internal Server Error",
                ErrorCode.INTERNAL_ERROR.getMessage()
        );

        return ResponseEntity.status(500).body(response);
    }
}