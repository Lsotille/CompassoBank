package com.example.compassobank.dto;

import lombok.Data;

@Data
public class GerenteDTO {
    private Long id;

    private Long agencia;

    private String cargo;

    private double salario;
}
