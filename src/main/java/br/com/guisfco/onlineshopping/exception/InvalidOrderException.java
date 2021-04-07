package br.com.guisfco.onlineshopping.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidOrderException extends RuntimeException {

    private static final long serialVersionUID = -2516783448252049103L;

    public InvalidOrderException(String message) {
        super(message);
    }
}
