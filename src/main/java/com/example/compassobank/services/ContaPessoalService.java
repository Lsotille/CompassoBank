package com.example.compassobank.services;


import com.example.compassobank.dto.*;
import org.springframework.stereotype.Service;

@Service
public interface ContaPessoalService {

    ContaPessoalDTO saque(Long id, OperacoesDTO valor);

    ContaPessoalDTO deposito(Long id, OperacoesDTO valor);

    ContaPessoalDTO salvar(ContaPessoalFormDTO body);

    ContaPessoalDTO procurar(long id);

    ContaPessoalDTO atualizar(long id, ContaPessoalFormDTO body);

    void remover(Long id);

    ContaPessoalDTO transferenciaExterna(Long id, OperacoesDTO valor);

    ContaPessoalDTO transferenciaInterna(Long id, OperacoesDTO valor, Long destinatario);

    ContaPessoalDTO aplicarPoupanca(Long id, OperacoesDTO valor);

    ContaPessoalDTO pagarCredito(Long id);
}
