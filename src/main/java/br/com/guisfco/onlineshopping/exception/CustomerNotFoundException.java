package br.com.guisfco.onlineshopping.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -6658088658870568608L;

    public CustomerNotFoundException() {
        super("O consumidor solicitado não foi encontrado.");
    }
}
