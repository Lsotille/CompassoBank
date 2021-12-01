package com.example.compassobank.dto;


import com.example.compassobank.entity.Endereco;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AgenciaFormDTO {

    private Integer instituicaoFinanceira;

    private String regiao;

    private String nomeDaAgencia;

    private Integer CNPJ;

    private BigDecimal balanco;

    private Endereco endereco;
}
