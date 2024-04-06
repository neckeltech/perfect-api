package tech.neckel.perfectApi.exception.errorResponse;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Instant;

public class ErrorResponseBuilder {
    private ErrorResponse errorResponse;

    private ErrorResponseBuilder(){

    }

    public static ErrorResponseBuilder builder(){
        ErrorResponseBuilder instance = new ErrorResponseBuilder();
        instance.errorResponse = new ErrorResponse();
        instance.errorResponse.setTimestamp(Instant.now());

        return instance;
    }

    public ErrorResponseBuilder status(HttpStatus httpStatus){
        errorResponse.setStatus(httpStatus.value());
        return this;
    }

    public ErrorResponseBuilder message(String message){
        errorResponse.setMessage(message);
        return this;
    }

    public ErrorResponseBuilder exception(Exception exception, boolean printStackTrace){
        if(printStackTrace){
            errorResponse.setStrackTrace(ExceptionUtils.getStackTrace(exception));
        }

        return this;
    }

    public ResponseEntity<Object> build(){
        return ResponseEntity.status(errorResponse.getStatus()).body(errorResponse);
    }
}
