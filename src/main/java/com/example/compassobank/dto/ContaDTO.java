package com.example.compassobank.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ContaDTO {

    private Long id;

    private String agencia;

    private BigDecimal saldo;

    private String senha;

    private BigDecimal juros;

}
