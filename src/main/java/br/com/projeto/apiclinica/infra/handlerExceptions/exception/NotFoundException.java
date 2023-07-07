package br.com.projeto.apiclinica.infra.handlerExceptions.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String msg) {
        super(msg);
    }
}
