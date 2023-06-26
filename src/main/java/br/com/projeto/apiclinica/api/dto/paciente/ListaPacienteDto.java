package br.com.projeto.apiclinica.api.dto.paciente;

import br.com.projeto.apiclinica.domain.models.Paciente;

public record ListaPacienteDto(Long id, String nome, String email, String telefone, String cpf) {

    public ListaPacienteDto(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf());
    }
}
