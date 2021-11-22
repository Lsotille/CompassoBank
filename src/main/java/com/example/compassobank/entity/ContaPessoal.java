package com.example.compassobank.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "ContaPessoal")
public class ContaPessoal extends Conta{

    private BigDecimal limite;

    private int cheques;

    private BigDecimal credito;

    private BigDecimal saldoAplicacao;

}
