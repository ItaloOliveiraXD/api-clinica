package br.com.projeto.apiclinica.domain.service;

import br.com.projeto.apiclinica.api.dto.consulta.DadosAgendamentoConsultaDTO;
import br.com.projeto.apiclinica.api.validacao.ValidadorAgendamentoDeConsulta;
import br.com.projeto.apiclinica.domain.models.Consulta;
import br.com.projeto.apiclinica.domain.models.Medico;
import br.com.projeto.apiclinica.domain.repository.ConsultaRepository;
import br.com.projeto.apiclinica.infra.handlerExceptions.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private List<ValidadorAgendamentoDeConsulta> validador;

    public AgendaDeConsultaService() {
    }

    public Consulta agendar(DadosAgendamentoConsultaDTO dados) {

        validador.forEach(v -> v.validar(dados));

        var paciente = pacienteService.pegaPaciente(dados.idPaciente());
        var medico = escolherMedico(dados);
        return consultaRepository.save(new Consulta(null, medico, paciente, dados.data()));
    }

    private Medico escolherMedico(DadosAgendamentoConsultaDTO dados) {

        if (dados.idMedico() != null) {
            return medicoService.pegaMedico(dados.idMedico());
        }

        if (dados.especialidade() == null) {
            throw new NotFoundException("Especialidade precisa ser informada ou escolha um médico.");
        }

        return medicoService.pegaMedicoAleatorio(dados);
    }
}
