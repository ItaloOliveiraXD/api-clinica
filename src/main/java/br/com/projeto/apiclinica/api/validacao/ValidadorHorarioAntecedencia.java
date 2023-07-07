package br.com.projeto.apiclinica.api.validacao;

import br.com.projeto.apiclinica.api.dto.consulta.DadosAgendamentoConsultaDTO;
import br.com.projeto.apiclinica.infra.handlerExceptions.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta{

    public void validar(DadosAgendamentoConsultaDTO dados){

        var dataConsulta = dados.data();
        var dataAgora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(dataAgora, dataConsulta).toMinutes();

        if (diferencaEmMinutos < 30) {
            throw new ValidacaoException("Consulta deve ser agendada com no mínimo 30 minutos antes.");
        }

    }
}
