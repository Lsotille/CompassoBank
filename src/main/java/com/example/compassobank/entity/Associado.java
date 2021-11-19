package com.example.compassobank.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "associados")
public class Associado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String trabalho;

    private Integer idade;

    private Integer cpf;

    private Integer cnpj;

    @OneToOne
    private Endereco endereco;

}
