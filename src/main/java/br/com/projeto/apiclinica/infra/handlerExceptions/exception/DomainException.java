package br.com.projeto.apiclinica.infra.handlerExceptions.exception;

public class DomainException extends RuntimeException{
    public DomainException(String msg) {
        super(msg);
    }
}
