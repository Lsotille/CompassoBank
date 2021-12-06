package com.example.compassobank.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "banqueiro")
@PrimaryKeyJoinColumn(name="id")
public class Banqueiro extends Associado{


    @ApiModelProperty(value = "Agencia")
    private Long agencia;

    @ApiModelProperty(value = "Cargo")
    private String cargo;

    @ApiModelProperty(value = "Salario")
    private double salario;

    @ApiModelProperty(value = "Aprovado")
    private boolean aprovado = false;
}



