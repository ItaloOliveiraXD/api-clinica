package br.com.projeto.apiclinica.api.controller;

import br.com.projeto.apiclinica.api.dto.consulta.DadosAgendamentoConsultaDTO;
import br.com.projeto.apiclinica.api.dto.consulta.DadosDetalhamentoConsultaDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @PostMapping
    public ResponseEntity<Object> agendar(@RequestBody @Valid DadosAgendamentoConsultaDTO dados) {
        System.out.println(dados);
        return ResponseEntity.ok().body(new DadosDetalhamentoConsultaDto(null, null, null, null));
    }
}
