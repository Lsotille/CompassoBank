package com.example.compassobank.services;

import com.example.compassobank.dto.ContaDTO;
import com.example.compassobank.dto.ContaFormDTO;
import com.example.compassobank.dto.OperacoesDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface ContaService {

    ContaDTO saque(Long id, OperacoesDTO valor);

    ContaDTO deposito(Long id, OperacoesDTO valor);

    ContaDTO salvar(ContaFormDTO body);

    ContaDTO procurar(long id);

    ContaDTO atualizar(long id, ContaFormDTO body);

    void remover(Long id);

}
