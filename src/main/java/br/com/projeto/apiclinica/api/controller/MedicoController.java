package br.com.projeto.apiclinica.api.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.projeto.apiclinica.api.dto.medico.DetalheMedicoDto;
import br.com.projeto.apiclinica.api.dto.medico.MedicoDto;
import br.com.projeto.apiclinica.domain.models.Medico;
import br.com.projeto.apiclinica.domain.service.MedicoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    
    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public ResponseEntity<DetalheMedicoDto> cadastra(@RequestBody @Valid MedicoDto medicoDto, UriComponentsBuilder uriBuilder) {

        Medico medico = medicoService.cadastraMedico(medicoDto);
        URI uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalheMedicoDto(medico));
    }
}
