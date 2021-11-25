package com.example.compassobank.services;


import com.example.compassobank.dto.*;
import org.springframework.stereotype.Service;

@Service
public interface GerenteService {

    GerenteDTO salvar(GerenteFormDTO body);

    GerenteDTO procurar(Long id);

    GerenteDTO atualizar(Long id, GerenteFormDTO body);

    void remover(Long id);

    ContaDTO aprovarConta(Long id);

    ContaPessoalDTO aprovarEmprestimoPessoal(Long id, OperacoesDTO body);

    ContaEmpresarialDTO aprovarEmprestimoEmpresarial(Long id, OperacoesDTO body);

    ContaPessoalDTO aprovarCheques(Long id, ChequesDTO valor);

    ContaDTO modificarJuros(Long id, OperacoesDTO body);

}
