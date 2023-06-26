package br.com.projeto.apiclinica.domain.service;

import br.com.projeto.apiclinica.api.dto.paciente.PacienteDto;
import br.com.projeto.apiclinica.domain.models.Paciente;
import br.com.projeto.apiclinica.domain.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Transactional
    public Paciente cadastraPaciente(PacienteDto pacienteDto) {

        return pacienteRepository.save(new Paciente(pacienteDto));
    }

    public Page<Paciente> listaPacientes(Pageable page) {

        return pacienteRepository.findAll(page);
    }

    public Paciente pegaPaciente(Long id) {

        Paciente paciente = pacienteRepository.findById(id).orElseThrow();
        return paciente;
    }

    @Transactional
    public void deletaPaciente(Long id) {

        Paciente paciente = pegaPaciente(id);
        pacienteRepository.delete(paciente);
    }
    
}
