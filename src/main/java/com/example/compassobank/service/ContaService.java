package com.example.compassobank.service;

import com.example.compassobank.dto.ContaDTO;
import com.example.compassobank.dto.ContaFormDTO;
import com.example.compassobank.dto.OperacoesDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Component
public interface ContaService {

    ContaDTO saque(Long id, OperacoesDTO valor);

    ContaDTO deposito(Long id, OperacoesDTO valor);

    ContaDTO salvar(ContaFormDTO body);

    ContaDTO procurar(long id);

    ContaDTO atualizar(long id, ContaFormDTO body);

    void remover(Long id);

}
