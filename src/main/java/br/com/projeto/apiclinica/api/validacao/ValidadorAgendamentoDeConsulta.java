package br.com.projeto.apiclinica.api.validacao;

import br.com.projeto.apiclinica.api.dto.consulta.DadosAgendamentoConsultaDTO;

public interface ValidadorAgendamentoDeConsulta {
    void validar(DadosAgendamentoConsultaDTO dados);
}
