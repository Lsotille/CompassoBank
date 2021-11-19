package com.example.compassobank.dto;

import lombok.Data;

@Data
public class ContaFormDTO {

    private String agencia;

    private double saldo;

    private String senha;

    private double juros;
}
