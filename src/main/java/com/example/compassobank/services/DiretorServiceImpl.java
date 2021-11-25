package com.example.compassobank.services;

import com.example.compassobank.dto.ContaEmpresarialDTO;
import com.example.compassobank.dto.ContaPessoalDTO;
import com.example.compassobank.entity.Conta;
import com.example.compassobank.entity.ContaEmpresarial;
import com.example.compassobank.entity.ContaPessoal;
import com.example.compassobank.repository.ContaEmpresarialRepository;
import com.example.compassobank.repository.ContaPessoalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


public class DiretorServiceImpl implements DiretorService{
    @Autowired
    private ContaPessoalRepository pessoalRepository;

    @Autowired
    private ContaEmpresarialRepository empresarialRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ContaPessoalDTO abonarDividaPessoal(Long id) {
        Optional<ContaPessoal> conta = this.pessoalRepository.findById(id);
        if (conta.isPresent()) {
                conta.get().setCredito(conta.get().getCredito().subtract(conta.get().getCredito()));
                Conta st = this.pessoalRepository.save(conta.get());
                return mapper.map(st, ContaPessoalDTO.class);
        }
        throw new RuntimeException("Conta não encontrada");
    }

    @Override
    public ContaEmpresarialDTO abonarDividaEmpresarial(Long id) {
        Optional<ContaEmpresarial> conta = this.empresarialRepository.findById(id);
        if (conta.isPresent()) {
            conta.get().setCredito(conta.get().getCredito().subtract(conta.get().getCredito()));
            Conta st = this.empresarialRepository.save(conta.get());
            return mapper.map(st, ContaEmpresarialDTO.class);
        }
        throw new RuntimeException("Conta não encontrada");
    }
}
