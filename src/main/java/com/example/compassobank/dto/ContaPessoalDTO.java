package com.example.compassobank.dto;

import lombok.Data;

@Data
public class ContaPessoalDTO {

    private Long id;

    private String agencia;

    private double saldo;

    private String senha;

    private double juros;

    private double limite;

    private int cheques;

    private double credito;

    private double saldoAplicacao;
}
