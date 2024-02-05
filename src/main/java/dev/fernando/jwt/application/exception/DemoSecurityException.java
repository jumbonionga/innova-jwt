package dev.fernando.jwt.application.exception;

import org.springframework.http.HttpStatus;
import dev.fernando.jwt.application.lasting.EMessage;

public class DemoSecurityException extends Exception{
    private HttpStatus statusCode;
    private String message;
    
    public DemoSecurityException(EMessage eMessage) {
        this.statusCode = eMessage.getStatusCode();
        this.message = eMessage.getMessage();
    }
}
