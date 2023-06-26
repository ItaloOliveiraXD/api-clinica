package br.com.projeto.apiclinica.api.dto.paciente;

import br.com.projeto.apiclinica.api.dto.endereco.EnderecoDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record PacienteDto(
    
        @NotBlank
        String nome,
        @NotBlank
        String telefone,
        @NotBlank
        @Email
        String email,
        @Pattern(regexp = "\\d{11,15}")
        String cpf,
        @NotNull
        @Valid
        EnderecoDto endereco) {
}