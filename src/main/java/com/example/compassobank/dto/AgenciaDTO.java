package com.example.compassobank.dto;
import lombok.Data;



@Data
public class AgenciaDTO {

    private Long id;

    private Integer instituicaoFinanceira;

    private String regiao;

    private String nomeDaAgencia;

    private Integer CNPJ;

}
