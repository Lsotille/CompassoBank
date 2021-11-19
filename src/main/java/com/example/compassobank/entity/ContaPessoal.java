package com.example.compassobank.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ContaPessoal")
public class ContaPessoal extends Conta{

    private double limite;

    private int cheques;

    private double credito;

    private double saldoAplicacao;

}
