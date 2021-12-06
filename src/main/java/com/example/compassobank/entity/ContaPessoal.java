package com.example.compassobank.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "ContaPessoal")
@PrimaryKeyJoinColumn(name="id")
public class ContaPessoal extends Conta{

    @ApiModelProperty(value = "Limite")
    private BigDecimal limite;

    @ApiModelProperty(value = "Cheques")
    private int cheques;

    @ApiModelProperty(value = "Credito")
    private BigDecimal credito;

    @ApiModelProperty(value = "Aplicacao")
    private BigDecimal saldoAplicacao;

}
