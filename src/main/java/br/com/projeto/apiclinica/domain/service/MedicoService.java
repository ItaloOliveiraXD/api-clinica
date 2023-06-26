package br.com.projeto.apiclinica.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.apiclinica.api.dto.medico.MedicoDto;
import br.com.projeto.apiclinica.domain.models.Medico;
import br.com.projeto.apiclinica.domain.repository.MedicoRepository;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Transactional
    public Medico cadastraMedico(MedicoDto medicoDto) {

        return medicoRepository.save(new Medico(medicoDto));
    }
    
}
