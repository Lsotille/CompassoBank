package com.example.compassobank.services;

import com.example.compassobank.dto.ContaDTO;
import com.example.compassobank.dto.OperacoesDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface ContaService {

    ContaDTO saque(Long id, OperacoesDTO valor);

    ContaDTO deposito(Long id, OperacoesDTO valor);
}
