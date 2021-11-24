package com.example.compassobank.services;


import com.example.compassobank.dto.*;
import com.example.compassobank.entity.ContaEmpresarial;

public interface BanqueiroService {
    BanqueiroDTO salvar(BanqueiroFormDTO body);

    BanqueiroDTO procurar(Long id);

    BanqueiroDTO atualizar(Long id, BanqueiroFormDTO body);

    void remover(Long id);

    ContaDTO aprovarConta(Long id);

    ContaPessoalDTO aprovarEmprestimoPessoal(Long id, OperacoesDTO body);

    ContaEmpresarialDTO aprovarEmprestimoEmpresarial(Long id, OperacoesDTO body);
}
