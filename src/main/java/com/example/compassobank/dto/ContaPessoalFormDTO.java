package com.example.compassobank.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ContaPessoalFormDTO {

    private Long agencia;

    private BigDecimal saldo;

    private String senha;

    private BigDecimal juros;

    private BigDecimal limite;

    private int cheques;

    private BigDecimal credito;

    private BigDecimal saldoAplicacao;

    private Long idAssociado;
}
