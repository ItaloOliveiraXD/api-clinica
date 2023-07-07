package br.com.projeto.apiclinica.domain.service;

import br.com.projeto.apiclinica.api.dto.consulta.DadosAgendamentoConsultaDTO;
import br.com.projeto.apiclinica.api.dto.medico.MedicoDto;
import br.com.projeto.apiclinica.domain.models.Medico;
import br.com.projeto.apiclinica.domain.repository.MedicoRepository;
import br.com.projeto.apiclinica.infra.handlerExceptions.exception.DomainException;
import br.com.projeto.apiclinica.infra.handlerExceptions.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Transactional
    public Medico cadastraMedico(MedicoDto medicoDto) {

        boolean existsByCrm = medicoRepository.existsByCrm(medicoDto.crm());
        boolean existsByEmail = medicoRepository.existsByEmail(medicoDto.email());

        if (existsByCrm) {
            throw new DomainException("CRM já está cadastrado!");
        }

        if (existsByEmail) {
            throw new DomainException("Email já está cadastrado!");
        }

        return medicoRepository.save(new Medico(medicoDto));
    }

    public Page<Medico> listaMedicos(Pageable page) {

        Page<Medico> medicos = medicoRepository.findAll(page);
        return medicos;
    }

    public Medico pegaMedico(Long id) {

        return medicoRepository.findById(id).orElseThrow(() -> new NotFoundException("Médico não encontrado!"));
        
    }

    @Transactional
    public void deletarMedico(Long id) {

        Medico medico = pegaMedico(id);
        medicoRepository.delete(medico);
    }

    public Medico pegaMedicoAleatorio(DadosAgendamentoConsultaDTO dados) {
        return medicoRepository.ecolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());
    }
}
