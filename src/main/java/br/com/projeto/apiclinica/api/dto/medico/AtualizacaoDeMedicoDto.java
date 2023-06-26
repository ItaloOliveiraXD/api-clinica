package br.com.projeto.apiclinica.api.dto.medico;

import br.com.projeto.apiclinica.api.dto.endereco.EnderecoDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record AtualizacaoDeMedicoDto(
        @NotNull
        Long id,
        String nome,
        String email,
        String telefone,
        @Valid
        EnderecoDto endereco) {

}
