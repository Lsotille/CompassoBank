package com.example.compassobank.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "conta")
@Inheritance(strategy = InheritanceType.JOINED)

public class Conta {

    @ApiModelProperty(value = "ID da Conta")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "ID da Agencia")
    private Long agencia;

    @ApiModelProperty(value = "Saldo")
    private BigDecimal saldo;

    @ApiModelProperty(value = "Senha")
    private String senha;

    @ApiModelProperty(value = "Juros")
    private BigDecimal juros;

    @ApiModelProperty(value = "Ativo")
    private boolean ativo = false;

    @ApiModelProperty(value = "Associado")
    @OneToOne
    private Associado associdado;

}
