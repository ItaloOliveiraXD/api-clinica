package br.com.projeto.apiclinica.api.dto.consulta;

import br.com.projeto.apiclinica.domain.models.Consulta;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsultaDto(Long id, Long idMedico, Long idPaciente, LocalDateTime data) {

    public DadosDetalhamentoConsultaDto(Consulta consulta) {
        this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getData());
    }
}
