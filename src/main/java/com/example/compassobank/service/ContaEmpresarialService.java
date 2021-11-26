package com.example.compassobank.service;

import com.example.compassobank.dto.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public interface ContaEmpresarialService {

    ContaEmpresarialDTO saque(Long id, OperacoesDTO valor);

    ContaEmpresarialDTO deposito(Long id, OperacoesDTO valor);

    ContaEmpresarialDTO salvar(ContaEmpresarialFormDTO body);

    ContaEmpresarialDTO procurar(long id);

    ContaEmpresarialDTO atualizar(long id, ContaEmpresarialFormDTO body);

    void remover(Long id);

    ContaEmpresarialDTO transferenciaExterna(Long id, OperacoesDTO valor);

    ContaEmpresarialDTO transferenciaInterna(Long id, OperacoesDTO valor, Long destinatario);

    ContaEmpresarialDTO aplicarPoupanca(Long id, OperacoesDTO valor);

    ContaEmpresarialDTO pagarCredito(Long id);
}
