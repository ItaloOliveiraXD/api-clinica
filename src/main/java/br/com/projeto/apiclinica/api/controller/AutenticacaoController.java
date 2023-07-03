package br.com.projeto.apiclinica.api.controller;

import br.com.projeto.apiclinica.api.dto.autenticacao.DadosLoginDto;
import br.com.projeto.apiclinica.api.dto.autenticacao.DadosTokenJWT;
import br.com.projeto.apiclinica.domain.models.Usuario;
import br.com.projeto.apiclinica.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<Object> efetuarLogin(@RequestBody @Valid DadosLoginDto dadosLoginDto) {

        var authenticationToken = new UsernamePasswordAuthenticationToken(dadosLoginDto.login(), dadosLoginDto.senha());
        var autenticacao = authenticationManager.authenticate(authenticationToken);

        String tokenJWT = tokenService.gerarToken((Usuario) autenticacao.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
