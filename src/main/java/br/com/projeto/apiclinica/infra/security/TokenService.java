package br.com.projeto.apiclinica.infra.security;

import br.com.projeto.apiclinica.domain.models.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.clinica.token.secret}")
    private String secret;

    public String gerarToken(Usuario usuario) {

        try {
            Algorithm algoritimo = Algorithm.HMAC512(secret);
            return JWT.create()
                    .withIssuer("API Clinica")
                    .withSubject(usuario.getLogin())
//                    .withClaim("id", usuario.getId())
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritimo);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar o token JWT", exception);
        }
    }

    public String getSubject(String tokenJWT) {

        try {
            Algorithm algoritimo = Algorithm.HMAC512(secret);
            return JWT.require(algoritimo)
                    .withIssuer("API Clinica")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception){
            throw new RuntimeException("Token JWT inválido ou expirado!");
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
