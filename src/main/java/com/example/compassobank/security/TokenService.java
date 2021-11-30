package com.example.compassobank.security;

import com.example.compassobank.entity.Associado;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${bank.jwt.expiration}")
    private String expiration;

    @Value("${bank.jwt.secret}")
    private String secret;

    public String gerarToken(Authentication authentication) {
        Associado logado = (Associado) authentication.getPrincipal();
        Date date = new Date();
        Date dateEx = new Date(date.getTime()+ Long.parseLong(expiration));
        return Jwts.builder()
                .setIssuer("Api CompassoBank")
                .setSubject(logado.getId().toString())
                .setIssuedAt(date)
                .setExpiration(dateEx)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean isTokenValido(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Long getIdAssociado(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }
}
