package com.example.compassobank.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "gerente")
public class Diretor extends Gerente{

    private String regiaoVigencia;

}
