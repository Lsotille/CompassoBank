package com.example.compassobank.dto;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
public class EnderecoDTO {

    private int numero;

    private String rua;

    private String bairro;

    private String cidade;

    private String estado;

    private String pais;

}
