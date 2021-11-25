package com.example.compassobank.services;

import com.example.compassobank.dto.ContaEmpresarialDTO;
import com.example.compassobank.dto.ContaPessoalDTO;

public interface DiretorService {

    ContaPessoalDTO abonarDividaPessoal(Long id);

    ContaEmpresarialDTO abonarDividaEmpresarial(Long id);
}
