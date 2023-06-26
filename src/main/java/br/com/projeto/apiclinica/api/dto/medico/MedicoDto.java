package br.com.projeto.apiclinica.api.dto.medico;

import br.com.projeto.apiclinica.api.dto.endereco.EnderecoDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MedicoDto(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone,
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotBlank
        String especialidade,
        @NotNull
        @Valid
        EnderecoDto endereco) {

}
