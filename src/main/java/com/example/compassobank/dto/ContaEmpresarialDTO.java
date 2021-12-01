package com.example.compassobank.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ContaEmpresarialDTO {

    private Long id;

    private Long agencia;

    private BigDecimal saldo;

    private String senha;

    private BigDecimal juros;

    private String nomeFantasia;

    private String razaoSocial;

    private String tipoEmpresa;

    private BigDecimal limite;

    private BigDecimal credito;

    private Long idAssociado;
}
