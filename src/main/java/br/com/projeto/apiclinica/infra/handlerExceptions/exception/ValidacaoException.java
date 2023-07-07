package br.com.projeto.apiclinica.infra.handlerExceptions.exception;

public class ValidacaoException extends RuntimeException{

    public ValidacaoException(String mensagem) {
        super(mensagem);
    }
}
