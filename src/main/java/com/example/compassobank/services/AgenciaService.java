package com.example.compassobank.services;

import com.example.compassobank.dto.AgenciaDTO;
import com.example.compassobank.dto.AgenciaFormDTO;
import org.springframework.stereotype.Service;

@Service
public interface AgenciaService {
    AgenciaDTO salvar(AgenciaFormDTO body);

    AgenciaDTO procurar(Long id);

    AgenciaDTO atualizar(Long id, AgenciaFormDTO body);

    void remover(Long id);
}
