package br.com.projeto.apiclinica.api.dto.consulta;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsultaDto(Long id, Long idMedico, Long idPaciente, LocalDateTime data) {

}
