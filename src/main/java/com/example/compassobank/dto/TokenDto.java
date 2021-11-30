package com.example.compassobank.dto;

import lombok.Data;

@Data
public class TokenDto {

    private final String token;
    private final String tipo;

    public TokenDto(String token, String tipo) {
        this.token = token;
        this.tipo = tipo;
    }
}
