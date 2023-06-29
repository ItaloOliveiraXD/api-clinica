package br.com.projeto.apiclinica.infra.validacao.exception;

public class DomainException extends RuntimeException{
    public DomainException(String msg) {
        super(msg);
    }
}
