package br.com.projeto.apiclinica.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.apiclinica.api.dto.autenticacao.DadosLoginDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<Object> efetuarLogin(@RequestBody @Valid DadosLoginDto dadosLoginDto) {

        var token = new UsernamePasswordAuthenticationToken(dadosLoginDto.login(), dadosLoginDto.senha());
        var autenticacao = authenticationManager.authenticate(token);

        return ResponseEntity.ok(autenticacao);
    }
}
