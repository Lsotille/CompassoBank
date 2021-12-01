package com.example.compassobank.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "ContaEmpresarial")
public class ContaEmpresarial extends Conta{

    @ApiModelProperty(value = "Nome Fantasia")
    private String nomeFantasia;

    @ApiModelProperty(value = "Razao Social")
    private String razaoSocial;

    @ApiModelProperty(value = "Tipo da Empresa")
    private String tipoEmpresa;

    @ApiModelProperty(value = "Limite")
    private BigDecimal limite;

    @ApiModelProperty(value = "Credito")
    private BigDecimal credito;

}