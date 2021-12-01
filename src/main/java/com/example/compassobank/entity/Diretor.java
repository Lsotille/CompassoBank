package com.example.compassobank.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "gerente")
public class Diretor extends Gerente{

    @ApiModelProperty(value = "Regiao de Vigencia")
    private String regiaoVigencia;

}
