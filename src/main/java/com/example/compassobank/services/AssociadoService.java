package com.example.compassobank.services;

import com.example.compassobank.dto.AssociadoDTO;
import com.example.compassobank.dto.AssociadoFormDTO;
import org.springframework.stereotype.Service;

@Service
public interface AssociadoService {
    AssociadoDTO salvar(AssociadoFormDTO body);

    AssociadoDTO procurar(Long id);

    AssociadoDTO atualizar(Long id, AssociadoFormDTO body);

    void remover(Long id);
}
