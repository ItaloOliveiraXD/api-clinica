package br.com.projeto.apiclinica.infra.validacao.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String msg) {
        super(msg);
    }
}
