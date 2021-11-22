package com.example.compassobank.dto;

import lombok.Data;

@Data
public class ContaEmpresarialFormDTO {

    private String agencia;

    private double saldo;

    private String senha;

    private double juros;

    private String nomeFantasia;

    private String razaoSocial;

    private String tipoEmpresa;

    private double limite;

    private double credito;

    private Long idAssociado;
}
