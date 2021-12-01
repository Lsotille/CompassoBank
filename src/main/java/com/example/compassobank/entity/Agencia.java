package com.example.compassobank.entity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "agencia")
public class Agencia {

    @ApiModelProperty(value = "ID da Agencia")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "Instituicao Financeira")
    private Integer instituicaoFinanceira;

    @ApiModelProperty(value = "Regiao")
    private String regiao;

    @ApiModelProperty(value = "Nome")
    private String nomeDaAgencia;

    @ApiModelProperty(value = "CNPJ")
    private Integer CNPJ;


    @ApiModelProperty(value = "Endereco")
     @OneToOne
    private Endereco endereco;
  
    @ApiModelProperty(value = "Balanco")
    private BigDecimal balanco;
  

}
