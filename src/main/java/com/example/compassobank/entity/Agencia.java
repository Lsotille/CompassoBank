package com.example.compassobank.entity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "agencia")
public class Agencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer instituicaoFinanceira;

    private String regiao;

    private String nomeDaAgencia;

    private Integer CNPJ;

    @OneToOne
    private Endereco endereco;

}
