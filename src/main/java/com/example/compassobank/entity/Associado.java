package com.example.compassobank.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "associados")
@Inheritance(strategy = InheritanceType.JOINED)
public class Associado {

    @ApiModelProperty(value = "ID do Associado")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "Nome")
    private String nome;

    @ApiModelProperty(value = "Trabalho")
    private String trabalho;

    @ApiModelProperty(value = "Idade")
    private Integer idade;

    @ApiModelProperty(value = "CPF")
    private Integer cpf;

    @ApiModelProperty(value = "CNPJ")
    private Integer cnpj;

    @ApiModelProperty(value = "Endereco")
    @OneToOne
    private Endereco endereco;

}
