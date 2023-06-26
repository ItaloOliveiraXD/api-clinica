package br.com.projeto.apiclinica.api.dto.paciente;

import br.com.projeto.apiclinica.api.dto.endereco.EnderecoDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record AtualizacaoDePacienteDto(

        @NotNull 
        Long id,
        String nome,
        String email,
        String telefone,
        @Valid 
        EnderecoDto endereco) {
}
