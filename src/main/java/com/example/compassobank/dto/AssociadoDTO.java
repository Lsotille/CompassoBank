package com.example.compassobank.dto;

import com.example.compassobank.entity.Endereco;
import lombok.Data;

@Data
public class AssociadoDTO {

    private Long id;

    private String nome;

    private String trabalho;

    private Integer idade;

    private Integer cpf;

    private Integer cnpj;

    private Endereco endereco;
}
