package com.example.compassobank.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "banqueiro")
public class Banqueiro extends Associado{


    private Long agencia;

    private String cargo;

    private double salario;

}



