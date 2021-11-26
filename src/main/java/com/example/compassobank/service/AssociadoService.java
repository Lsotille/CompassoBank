package com.example.compassobank.service;

import com.example.compassobank.dto.AssociadoDTO;
import com.example.compassobank.dto.AssociadoFormDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public interface AssociadoService {
    AssociadoDTO salvar(AssociadoFormDTO body);

    AssociadoDTO procurar(Long id);

    AssociadoDTO atualizar(Long id, AssociadoFormDTO body);

    void remover(Long id);
}
