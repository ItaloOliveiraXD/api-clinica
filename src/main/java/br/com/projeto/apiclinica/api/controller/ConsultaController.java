package br.com.projeto.apiclinica.api.controller;

import br.com.projeto.apiclinica.api.dto.consulta.DadosAgendamentoConsultaDTO;
import br.com.projeto.apiclinica.api.dto.consulta.DadosDetalhamentoConsultaDto;
import br.com.projeto.apiclinica.domain.service.AgendaDeConsultaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultas")
@SecurityRequirement(name = "bearer-key")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultaService agendaDeConsultaService;

    @PostMapping
    public ResponseEntity<DadosDetalhamentoConsultaDto> agendar(@RequestBody @Valid DadosAgendamentoConsultaDTO dados) {
        var consulta = agendaDeConsultaService.agendar(dados);
        return ResponseEntity.ok().body(new DadosDetalhamentoConsultaDto(consulta));
    }
}
