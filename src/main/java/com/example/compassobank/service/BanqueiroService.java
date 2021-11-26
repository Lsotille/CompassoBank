package com.example.compassobank.service;


import com.example.compassobank.dto.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public interface BanqueiroService {

    BanqueiroDTO salvar(BanqueiroFormDTO body);

    BanqueiroDTO procurar(Long id);

    BanqueiroDTO atualizar(Long id, BanqueiroFormDTO body);

    void remover(Long id);

    ContaDTO aprovarConta(Long id);

    ContaPessoalDTO aprovarEmprestimoPessoal(Long id, OperacoesDTO body);

    ContaEmpresarialDTO aprovarEmprestimoEmpresarial(Long id, OperacoesDTO body);

    ContaDTO saldoParaMoedaEstrangeira(Long id, OperacoesDTO valor);
}
