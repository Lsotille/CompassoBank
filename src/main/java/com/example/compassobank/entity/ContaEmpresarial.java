package com.example.compassobank.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "ContaEmpresarial")
public class ContaEmpresarial extends Conta{

    private String nomeFantasia;

    private String razaoSocial;

    private String tipoEmpresa;

    private double limite;

    private double credito;

}