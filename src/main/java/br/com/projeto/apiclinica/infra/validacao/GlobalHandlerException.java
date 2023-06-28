package br.com.projeto.apiclinica.infra.validacao;

import br.com.projeto.apiclinica.infra.validacao.exception.DomainException;
import br.com.projeto.apiclinica.infra.validacao.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalHandlerException extends ResponseEntityExceptionHandler {
   
    @Autowired
    private MessageSource messageSource;

    @Override
    @Nullable
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<CamposErros> campos = new ArrayList<>();
        List<FieldError> errors = ex.getBindingResult().getFieldErrors();
        errors.forEach(e -> {
            String campo = e.getField();
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            campos.add(new CamposErros(campo, mensagem));
        });

        ResponseError responseError = new ResponseError();
        responseError.setStatus("Preencha todos os campos Obrigatório!");
        responseError.setStatusCode(status.value());
        responseError.setDateTime(LocalDateTime.now());
        responseError.setCampos(campos);

        return super.handleExceptionInternal(ex, responseError, headers, status, request);
    }

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<Object> conflictError(DomainException ex, WebRequest request) {

        HttpStatus status = HttpStatus.CONFLICT;

        ResponseError responseError = new ResponseError();
        responseError.setStatus(ex.getMessage());
        responseError.setStatusCode(status.value());
        responseError.setDateTime(LocalDateTime.now());

        return handleExceptionInternal(ex, responseError, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> notFoundError(NotFoundException ex, WebRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;

        ResponseError responseError = new ResponseError();
        responseError.setStatus(ex.getMessage());
        responseError.setStatusCode(status.value());
        responseError.setDateTime(LocalDateTime.now());

        return handleExceptionInternal(ex, responseError, new HttpHeaders(), status, request);
    }
}
