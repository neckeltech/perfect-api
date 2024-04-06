package tech.neckel.perfectApi.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import tech.neckel.perfectApi.exception.BadResquestException;
import tech.neckel.perfectApi.exception.ConflitResquestException;
import tech.neckel.perfectApi.exception.NotFoundResquestException;
import tech.neckel.perfectApi.exception.errorResponse.ErrorResponseBuilder;

@Slf4j(topic = "GLOBAL_EXCEPTION_HANDLER")
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Value("${server.include.exception}")
    private boolean printStackTrace;

    @ExceptionHandler(BadResquestException.class)
    public ResponseEntity<Object> handleAllBadRequest(Exception exception){
        String errorMessage = exception.getMessage();
        log.error(errorMessage, exception);

        return ErrorResponseBuilder.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message(errorMessage)
                .exception(exception, printStackTrace)
                .build();
    }

    @ExceptionHandler(ConflitResquestException.class)
    public ResponseEntity<Object> handleAllConflitException(Exception exception){
        String errorMessage = exception.getMessage();
        log.error(errorMessage, exception);

        return ErrorResponseBuilder.builder()
                .status(HttpStatus.CONFLICT)
                .message(errorMessage)
                .exception(exception, printStackTrace)
                .build();
    }

    @ExceptionHandler(NotFoundResquestException.class)
    public ResponseEntity<Object> handleAllNotFoundResquestException(Exception exception){
        String errorMessage = exception.getMessage();
        log.error(errorMessage, exception);

        return ErrorResponseBuilder.builder()
                .status(HttpStatus.NOT_FOUND)
                .message(errorMessage)
                .exception(exception, printStackTrace)
                .build();
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Object> handleAllAccessDeniedException(Exception exception){
        String errorMessage = exception.getMessage();
        log.error(errorMessage, exception);

        return ErrorResponseBuilder.builder()
                .status(HttpStatus.FORBIDDEN)
                .message(errorMessage)
                .exception(exception, printStackTrace)
                .build();
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleAllDataIntegriTyViolationException(Exception exception){
        String errorMessage = exception.getMessage();
        log.error(errorMessage, exception);

        return ErrorResponseBuilder.builder()
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .message(errorMessage)
                .exception(exception, printStackTrace)
                .build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllUncaughtException(Exception exception){
        String errorMessage = "Unknown error occured";
        log.error(errorMessage, exception);

        return ErrorResponseBuilder.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(errorMessage)
                .exception(exception, printStackTrace)
                .build();
    }
}
