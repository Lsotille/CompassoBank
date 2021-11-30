package com.example.compassobank.service;


import com.example.compassobank.dto.*;

import com.example.compassobank.entity.Agencia;
import com.example.compassobank.entity.Conta;
import com.example.compassobank.repository.AgenciaRepository;
import com.example.compassobank.repository.ContaRepository;
import com.example.compassobank.service.ContaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

import static org.aspectj.runtime.internal.Conversions.floatValue;

@Service
public class ContaServiceImpl implements ContaService {

    @Autowired
    private ContaRepository repository;

    @Autowired
    private AgenciaRepository agenciaRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ContaDTO saque(Long id, OperacoesDTO valor) {
        Optional<Conta> conta = this.repository.findById(id);
        Optional<Agencia> agencia = this.agenciaRepository.findById(conta.get().getAgencia());
        float saldo = floatValue(conta.get().getSaldo());
        float valorF = floatValue(valor.getValor());
        if (conta.isPresent()) {
            if (saldo > valorF) {
                conta.get().setSaldo(conta.get().getSaldo().subtract(valor.getValor()));
                agencia.get().setBalanco(agencia.get().getBalanco().subtract(valor.getValor()));
                Conta st = this.repository.save(conta.get());
                return mapper.map(st, ContaDTO.class);
            } else {
                throw new RuntimeException("Sem saldo Suficiente");
            }
        }
        throw new RuntimeException("Conta não encontrada");
    }


    @Override
    public ContaDTO deposito(Long id, OperacoesDTO valor) {
        Optional<Conta> conta = this.repository.findById(id);
        Optional<Agencia> agencia = this.agenciaRepository.findById(conta.get().getAgencia());
        if (conta.isPresent()){
            conta.get().setSaldo(conta.get().getSaldo().add(valor.getValor()));
            agencia.get().setBalanco(agencia.get().getBalanco().add(valor.getValor()));
            Conta st = this.repository.save(conta.get());
            return mapper.map(st, ContaDTO.class);
        }
        throw new RuntimeException("Conta não encontrada");
    }

    @Override
    public ContaDTO salvar(ContaFormDTO body) {
        Conta conta = mapper.map(body, Conta.class);
        Conta contasResponse = this.repository.save(conta);
        return mapper.map(contasResponse, ContaDTO.class);
    }

    @Override
    public ContaDTO procurar(long id) {
        Optional<Conta> conta = this.repository.findById(id);
        if (conta.isPresent()) {
            return mapper.map(conta.get(),ContaDTO.class);
        }
        throw new RuntimeException("Conta não encontrada");
    }


    @Override
    public ContaDTO atualizar(long id, ContaFormDTO body) {
        Optional<Conta> conta = this.repository.findById(id);
        if (conta.isPresent()) {
            conta.get().setSenha(body.getSenha());
            Conta st = this.repository.save(conta.get());
            return mapper.map(st, ContaDTO.class);
        }
        throw new RuntimeException("Conta não encontrada");
    }

    @Override
    public void remover(Long id) {
        Conta conta = this.repository.findById(id).get();
        this.repository.delete(conta);

    }
}
