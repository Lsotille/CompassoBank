package com.example.compassobank.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero;

    private String rua;

    private String bairro;

    private String cidade;

    private String estado;

    private String pais;


}
