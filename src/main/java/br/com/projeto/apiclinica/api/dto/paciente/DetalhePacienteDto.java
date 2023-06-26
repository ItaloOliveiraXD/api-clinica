package br.com.projeto.apiclinica.api.dto.paciente;

import br.com.projeto.apiclinica.domain.models.Endereco;
import br.com.projeto.apiclinica.domain.models.Paciente;

public record DetalhePacienteDto(Long id, String nome, String email, String telefone, String cpf,
        Endereco endereco) {

    public DetalhePacienteDto(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(),
                paciente.getEndereco());
    }
}
