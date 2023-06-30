package br.com.projeto.apiclinica.api.dto.autenticacao;

import jakarta.validation.constraints.NotBlank;

public record DadosLoginDto(@NotBlank String login, @NotBlank String senha) {
    
}
