package br.com.projeto.apiclinica.domain.service;

import br.com.projeto.apiclinica.api.dto.medico.MedicoDto;
import br.com.projeto.apiclinica.domain.models.Medico;
import br.com.projeto.apiclinica.domain.repository.MedicoRepository;
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

        return medicoRepository.save(new Medico(medicoDto));
    }

    public Page<Medico> listaMedicos(Pageable page) {

        Page<Medico> medicos = medicoRepository.findAll(page);
        return medicos;
    }

    public Medico pegaMedico(Long id) {

        Medico medico = medicoRepository.findById(id).orElseThrow();
        return medico;
    }

    public void deletarMedico(Long id) {

        Medico medico = pegaMedico(id);
        medicoRepository.delete(medico);
    }

}
