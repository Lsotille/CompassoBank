package com.example.compassobank.service;

import com.example.compassobank.dto.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public interface DiretorService {

    DiretorDTO salvar(DiretorFormDTO body);

    DiretorDTO procurar(Long id);

    DiretorDTO atualizar(Long id, DiretorFormDTO body);

    void remover(Long id);

    ContaDTO aprovarConta(Long id);

    ContaPessoalDTO aprovarEmprestimoPessoal(Long id, OperacoesDTO body);

    ContaEmpresarialDTO aprovarEmprestimoEmpresarial(Long id, OperacoesDTO body);

    ContaPessoalDTO aprovarCheques(Long id, ChequesDTO valor);

    ContaDTO modificarJuros(Long id, OperacoesDTO body);

    ContaPessoalDTO abonarDividaPessoal(Long id);

    ContaEmpresarialDTO abonarDividaEmpresarial(Long id);

    BanqueiroDTO promoverBanqueiro(Long id);

    GerenteDTO promoverGerente(Long id);
}
