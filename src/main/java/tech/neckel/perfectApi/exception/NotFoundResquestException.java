package tech.neckel.perfectApi.exception;

public class NotFoundResquestException extends RuntimeException {
    public NotFoundResquestException(String message){
        super(message);
    }
}
