package com.example.compassobank.service;

import com.example.compassobank.dto.AgenciaDTO;
import com.example.compassobank.dto.AgenciaFormDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Component
public interface AgenciaService {
    AgenciaDTO salvar(AgenciaFormDTO body);

    AgenciaDTO procurar(Long id);

    AgenciaDTO atualizar(Long id, AgenciaFormDTO body);

    void remover(Long id);

    BigDecimal divisaoLucros(Long id);
}
