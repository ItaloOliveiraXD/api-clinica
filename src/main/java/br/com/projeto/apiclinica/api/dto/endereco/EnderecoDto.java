package br.com.projeto.apiclinica.api.dto.endereco;

import jakarta.validation.constraints.NotBlank;

public record EnderecoDto(
        @NotBlank
        String logradouro,
        @NotBlank
        String bairro,
        @NotBlank
        String cep,
        @NotBlank
        String cidade,
        @NotBlank
        String uf,
        @NotBlank
        String numero,
        String complemento) {

}
