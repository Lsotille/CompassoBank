package com.example.compassobank.dto;

import lombok.Data;

@Data
public class BanqueiroDTO {

    private Long id;

    private Long agencia;

    private String cargo;

    private double salario;
}
