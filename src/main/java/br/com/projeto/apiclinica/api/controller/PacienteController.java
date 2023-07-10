package br.com.projeto.apiclinica.api.controller;

import br.com.projeto.apiclinica.api.dto.paciente.AtualizacaoDePacienteDto;
import br.com.projeto.apiclinica.api.dto.paciente.DetalhePacienteDto;
import br.com.projeto.apiclinica.api.dto.paciente.ListaPacienteDto;
import br.com.projeto.apiclinica.api.dto.paciente.PacienteDto;
import br.com.projeto.apiclinica.domain.models.Paciente;
import br.com.projeto.apiclinica.domain.service.PacienteService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pacientes")
@SecurityRequirement(name = "bearer-key")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<DetalhePacienteDto> cadastra(@RequestBody @Valid PacienteDto pacienteDto,
            UriComponentsBuilder uriBuilder) {

        Paciente paciente = pacienteService.cadastraPaciente(pacienteDto);
        URI uri = uriBuilder.path("pacientes/{id}").buildAndExpand(paciente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhePacienteDto(paciente));
    }

    @GetMapping
    public ResponseEntity<Page<ListaPacienteDto>> lista(@PageableDefault(size = 5, sort = "nome") Pageable page) {

        Page<ListaPacienteDto> pacientes = pacienteService.listaPacientes(page).map(ListaPacienteDto::new);
        return ResponseEntity.ok().body(pacientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhePacienteDto> visualiza(@PathVariable Long id) {

        Paciente paciente = pacienteService.pegaPaciente(id);
        return ResponseEntity.ok().body(new DetalhePacienteDto(paciente));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DetalhePacienteDto> atualiza(
            @RequestBody @Valid AtualizacaoDePacienteDto atualizacaoDePaciente) {

        Paciente paciente = pacienteService.pegaPaciente(atualizacaoDePaciente.id());
        paciente.atualizarPaciente(atualizacaoDePaciente);

        return ResponseEntity.ok().body(new DetalhePacienteDto(paciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleta(@PathVariable Long id) {

        pacienteService.deletaPaciente(id);
        return ResponseEntity.noContent().build();
    }
}
