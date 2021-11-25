package com.example.compassobank.services;

import com.example.compassobank.dto.*;
import com.example.compassobank.entity.Conta;
import com.example.compassobank.entity.ContaEmpresarial;
import com.example.compassobank.entity.ContaPessoal;
import com.example.compassobank.repository.ContaEmpresarialRepository;
import com.example.compassobank.repository.ContaPessoalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class GerenteServiceImpl implements GerenteService{
    @Autowired
    private ContaPessoalRepository pessoalRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ContaPessoalDTO aprovarCheques(Long id, ChequesDTO valor) {
        Optional<ContaPessoal> conta = this.pessoalRepository.findById(id);
        if (conta.isPresent()){
            conta.get().setCheques(conta.get().getCheques()+(valor.getValor()));
            Conta st = this.pessoalRepository.save(conta.get());
            return mapper.map(st, ContaPessoalDTO.class);
        }
        throw new RuntimeException("Conta não encontrada");
    }

}
