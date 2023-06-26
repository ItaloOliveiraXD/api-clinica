package br.com.projeto.apiclinica.api.dto.medico;

import br.com.projeto.apiclinica.domain.models.Especialidade;
import br.com.projeto.apiclinica.domain.models.Medico;

public record ListaMedicoDto(Long id, String nome, String email, String telefone, String crm,
        Especialidade especialidade) {

    public ListaMedicoDto(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getTelefone(), medico.getCrm(),
                medico.getEspecialidade());
    }
}
