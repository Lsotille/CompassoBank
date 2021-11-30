package com.example.compassobank.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long agencia;

    private BigDecimal saldo;

    private String senha;

    private BigDecimal juros;

    private boolean ativo = false;

    @OneToOne
    private Associado associdado;

}
