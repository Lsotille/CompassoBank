package com.example.compassobank.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ContaFormDTO {

    private String agencia;

    private BigDecimal saldo;

    private String senha;

    private BigDecimal juros;

    private Long idAssociado;
}
