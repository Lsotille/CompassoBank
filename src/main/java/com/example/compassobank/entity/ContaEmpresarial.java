package com.example.compassobank.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "ContaEmpresarial")
public class ContaEmpresarial extends Conta{

    private String nomeFantasia;

    private String razaoSocial;

    private String tipoEmpresa;

    private BigDecimal limite;

    private BigDecimal credito;

}