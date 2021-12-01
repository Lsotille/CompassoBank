package com.example.compassobank.entity;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "endereco")
public class Endereco {
    @ApiModelProperty(value = "ID do Endereco")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "Numero")
    private int numero;

    @ApiModelProperty(value = "Rua")
    private String rua;

    @ApiModelProperty(value = "Bairro")
    private String bairro;

    @ApiModelProperty(value = "Cidade")
    private String cidade;

    @ApiModelProperty(value = "Estado")
    private String estado;

    @ApiModelProperty(value = "Pais")
    private String pais;


}
