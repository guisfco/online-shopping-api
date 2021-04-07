package br.com.guisfco.onlineshopping.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -3724226030076934480L;

    public ProductNotFoundException() {
        super("O produto solicitado não foi encontrado.");
    }
}
