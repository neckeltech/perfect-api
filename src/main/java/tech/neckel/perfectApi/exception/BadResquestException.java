package tech.neckel.perfectApi.exception;

public class BadResquestException extends RuntimeException {
    public BadResquestException(String message){
        super(message);
    }
}
