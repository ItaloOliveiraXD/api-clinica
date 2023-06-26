package br.com.projeto.apiclinica.api.controller;

import br.com.projeto.apiclinica.api.dto.paciente.DetalhePacienteDto;
import br.com.projeto.apiclinica.api.dto.paciente.PacienteDto;
import br.com.projeto.apiclinica.domain.models.Paciente;
import br.com.projeto.apiclinica.domain.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    
    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<DetalhePacienteDto> cadastra(@RequestBody @Valid PacienteDto pacienteDto, UriComponentsBuilder uriBuilder ) {

        Paciente paciente = pacienteService.cadastraPaciente(pacienteDto);
        URI uri = uriBuilder.path("pacientes/{id}").buildAndExpand(paciente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhePacienteDto(paciente));
    }
}
