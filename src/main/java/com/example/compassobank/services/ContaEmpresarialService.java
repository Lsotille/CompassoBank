package com.example.compassobank.services;

import com.example.compassobank.dto.*;

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
