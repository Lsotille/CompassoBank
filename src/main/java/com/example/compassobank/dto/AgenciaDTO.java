package com.example.compassobank.dto;
import com.example.compassobank.entity.Endereco;
import lombok.Data;



@Data
public class AgenciaDTO {

    private Long id;

    private Integer instituicaoFinanceira;

    private String regiao;

    private String nomeDaAgencia;

    private Integer CNPJ;

    private Endereco endereco;
}
