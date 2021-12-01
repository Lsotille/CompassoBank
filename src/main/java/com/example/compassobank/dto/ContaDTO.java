package com.example.compassobank.dto;

import com.example.compassobank.entity.Associado;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ContaDTO {

    private Long id;

    private Long agencia;

    private BigDecimal saldo;

    private String senha;

    private BigDecimal juros;

    private Long idAssociado;

}
