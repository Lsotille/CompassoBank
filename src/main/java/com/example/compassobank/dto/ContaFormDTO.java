package com.example.compassobank.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ContaFormDTO {

    private Long agencia;

    private BigDecimal saldo;

    private String senha;

    private BigDecimal juros;

    private Long idAssociado;
}
