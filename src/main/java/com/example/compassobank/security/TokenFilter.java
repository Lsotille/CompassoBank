package com.example.compassobank.security;

import com.example.compassobank.entity.Associado;
import com.example.compassobank.repository.AssociadoRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenFilter extends OncePerRequestFilter {

    private TokenService tokenService;
    private AssociadoRepository repository;

    public TokenFilter(TokenService tokenService, AssociadoRepository repository) {
        this.tokenService = tokenService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = recuperarToken(request);
        boolean valido = tokenService.isTokenValido(token);

        if (valido){
            autenticarCliente(token);
        }
        filterChain.doFilter(request, response);
    }

    private void autenticarCliente(String token) {
        Long idAssociado = tokenService.getIdAssociado(token);
        Associado associado = repository.findById(idAssociado).get();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(associado, null, associado.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String recuperarToken(HttpServletRequest request) {
         String token = request.getHeader("Authorization");
         if (token == null || token.isEmpty() || !token.startsWith("Bearer ")){
             return null;
         }
         return token.substring(7, token.length());
    }
}
