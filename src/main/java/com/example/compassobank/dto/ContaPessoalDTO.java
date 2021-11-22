package com.example.compassobank.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ContaPessoalDTO {

    private Long id;

    private String agencia;

    private BigDecimal saldo;

    private String senha;

    private BigDecimal juros;

    private BigDecimal limite;

    private int cheques;

    private BigDecimal credito;

    private BigDecimal saldoAplicacao;
}
