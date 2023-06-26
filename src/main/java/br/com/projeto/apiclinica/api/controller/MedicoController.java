package br.com.projeto.apiclinica.api.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.projeto.apiclinica.api.dto.medico.DetalheMedicoDto;
import br.com.projeto.apiclinica.api.dto.medico.ListaMedicoDto;
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
    public ResponseEntity<DetalheMedicoDto> cadastra(@RequestBody @Valid MedicoDto medicoDto,
            UriComponentsBuilder uriBuilder) {

        Medico medico = medicoService.cadastraMedico(medicoDto);
        URI uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalheMedicoDto(medico));
    }

    @GetMapping
    public ResponseEntity<Page<ListaMedicoDto>> lista(@PageableDefault(size = 5, sort = "nome") Pageable page) {

        Page<ListaMedicoDto> medicos = medicoService.listaMedicos(page).map(ListaMedicoDto::new);

        return ResponseEntity.ok().body(medicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalheMedicoDto> visualiza(@PathVariable Long id) {

        Medico medico = medicoService.pegaMedico(id);
        return ResponseEntity.ok().body(new DetalheMedicoDto(medico));
    }
}
