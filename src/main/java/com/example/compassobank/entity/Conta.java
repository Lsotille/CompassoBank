package com.example.compassobank.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String agencia;

    private double saldo;

    private String senha;

    private double juros;

}
