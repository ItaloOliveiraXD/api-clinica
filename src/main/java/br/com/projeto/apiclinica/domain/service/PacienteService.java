package br.com.projeto.apiclinica.domain.service;

import br.com.projeto.apiclinica.api.dto.paciente.PacienteDto;
import br.com.projeto.apiclinica.domain.models.Paciente;
import br.com.projeto.apiclinica.domain.repository.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente cadastraPaciente(@Valid PacienteDto pacienteDto) {

        return pacienteRepository.save(new Paciente(pacienteDto));
    }
    
}
