package com.example.demologincsr.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demologincsr.common.ErrorMessageEnum;
import com.example.demologincsr.constant.Constants;
import com.example.demologincsr.entity.User;
import com.example.demologincsr.service.AuthService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Collections;
import java.util.Date;

@Component
public class UserAuthProvider {

    @Autowired
    private AuthService authService;

    private String secretKey = "secret-key";

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public Authentication validateToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decoder = verifier.verify(token);
        return new UsernamePasswordAuthenticationToken(authService.findByUsername(decoder.getIssuer()), null, Collections.emptyList());

    }

    public Authentication validateUser(User user) {
        return new UsernamePasswordAuthenticationToken(authService.validateUser(user), null, Collections.emptyList());
    }

    public String createToken(String username) {
        try {
            Date now = new Date();
            Date expiry = new Date(now.getTime() + Constants.TOKEN_EXPIRE_MILLISECONDS);
            return JWT.create()
                    .withIssuer(username)
                    .withIssuedAt(now)
                    .withExpiresAt(expiry)
                    .sign(Algorithm.HMAC256(secretKey));
        } catch (Exception e) {
            throw new RuntimeException(ErrorMessageEnum.CREATE_TOKEN_FAILED.getCode());
        }
    }
}
