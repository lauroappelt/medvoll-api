package med.voll.api.infra.security;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import med.voll.api.domain.usuario.Usuario;

@Service
public class TokenService {
    
    @Value("api.secutiry.token.secret")
    private String secret;

    public String gerarToken(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                .withIssuer("minha api")
                .withSubject(usuario.getLogin())
                .withExpiresAt(dataExpiracao())
                .sign(algorithm);

            return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar token");
        }
    }

    public Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
