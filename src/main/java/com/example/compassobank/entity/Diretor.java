package com.example.compassobank.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "diretor")
@PrimaryKeyJoinColumn(name="id")
public class Diretor extends Gerente{

    @ApiModelProperty(value = "Regiao de Vigencia")
    private String regiaoVigencia;

}
