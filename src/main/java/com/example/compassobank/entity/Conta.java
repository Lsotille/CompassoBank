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

    private String agencia;

    private BigDecimal saldo;

    private String senha;

    private BigDecimal juros;

    @OneToOne
    private Associado associdado;

}
