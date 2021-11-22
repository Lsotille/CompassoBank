package com.example.compassobank.services;

import com.example.compassobank.dto.*;
import com.example.compassobank.entity.Conta;
import com.example.compassobank.entity.ContaPessoal;
import com.example.compassobank.repository.ContaPessoalRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.aspectj.runtime.internal.Conversions.floatValue;

public class ContaPessoalServiceImpl implements ContaPessoalService {
    @Autowired
    private ContaPessoalRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ContaPessoalDTO saque(Long id, OperacoesDTO valor) {
        Optional<ContaPessoal> conta = this.repository.findById(id);
        float saldo = floatValue(conta.get().getSaldo());
        float valorF = floatValue(valor.getValor());
        if (conta.isPresent()) {
            if (saldo > valorF) {
                conta.get().setSaldo(conta.get().getSaldo().subtract(valor.getValor()));
                Conta st = this.repository.save(conta.get());
                return mapper.map(st, ContaPessoalDTO.class);
            } else {
                throw new RuntimeException("Sem saldo Suficiente");
            }
        }
        throw new RuntimeException("Conta não encontrada");
    }


    @Override
    public ContaPessoalDTO deposito(Long id, OperacoesDTO valor) {
        Optional<ContaPessoal> conta = this.repository.findById(id);
        if (conta.isPresent()) {
            conta.get().setSaldo(conta.get().getSaldo().add(valor.getValor()));
            Conta st = this.repository.save(conta.get());
            return mapper.map(st, ContaPessoalDTO.class);
        }
        throw new RuntimeException("Conta não encontrada");
    }

    @Override
    public ContaPessoalDTO salvar(ContaPessoalFormDTO body) {
        ContaPessoal conta = mapper.map(body, ContaPessoal.class);
        ContaPessoal contasResponse = this.repository.save(conta);
        return mapper.map(contasResponse, ContaPessoalDTO.class);
    }

    @Override
    public ContaPessoalDTO procurar(long id) {
        Optional<ContaPessoal> conta = this.repository.findById(id);
        if (conta.isPresent()) {
            return mapper.map(conta.get(), ContaPessoalDTO.class);
        }
        throw new RuntimeException("Conta não encontrada");
    }


    @Override
    public ContaPessoalDTO atualizar(long id, ContaPessoalFormDTO body) {
        Optional<ContaPessoal> conta = this.repository.findById(id);
        if (conta.isPresent()) {
            conta.get().setSenha(body.getSenha());
            Conta st = this.repository.save(conta.get());
            return mapper.map(st, ContaPessoalDTO.class);
        }
        throw new RuntimeException("Conta não encontrada");
    }

    @Override
    public void remover(Long id) {
        ContaPessoal conta = this.repository.findById(id).get();
        this.repository.delete(conta);

    }

    @Override
    public ContaPessoalDTO transferenciaExterna(Long id, OperacoesDTO valor) {
        Optional<ContaPessoal> conta = this.repository.findById(id);
        float saldo = floatValue(conta.get().getSaldo());
        float valorF = floatValue(valor.getValor());
        if (conta.isPresent()) {
            if (saldo > valorF) {
                conta.get().setSaldo(conta.get().getSaldo().subtract(valor.getValor()));
                Conta st = this.repository.save(conta.get());
                return mapper.map(st, ContaPessoalDTO.class);
            } else {
                throw new RuntimeException("Sem saldo Suficiente");
            }
        }
        throw new RuntimeException("Conta não encontrada");
    }

    @Override
    public ContaPessoalDTO transferenciaInterna(Long id, OperacoesDTO valor, Long destinatario) {
        Optional<ContaPessoal> conta = this.repository.findById(id);
        Optional<ContaPessoal> recebedor = this.repository.findById(destinatario);
        float saldo = floatValue(conta.get().getSaldo());
        float valorF = floatValue(valor.getValor());
        if (conta.isPresent() && recebedor.isPresent()) {
            if (saldo > valorF) {
                conta.get().setSaldo(conta.get().getSaldo().subtract(valor.getValor()));
                Conta st = this.repository.save(conta.get());
                recebedor.get().setSaldo(recebedor.get().getSaldo().add(valor.getValor()));
                Conta st2 = this.repository.save(recebedor.get());
                return mapper.map(st, ContaPessoalDTO.class);
            } else {
                throw new RuntimeException("Sem saldo Suficiente");
            }
        }
        throw new RuntimeException("Conta não encontrada");
    }

    @Override
    public ContaPessoalDTO aplicarPoupanca(Long id, OperacoesDTO valor) {
        Optional<ContaPessoal> conta = this.repository.findById(id);
        float saldo = floatValue(conta.get().getSaldo());
        float valorF = floatValue(valor.getValor());
        if (conta.isPresent()) {
            if (saldo > valorF) {
                conta.get().setSaldo(conta.get().getSaldo().subtract(valor.getValor()));
                conta.get().setSaldoAplicacao(conta.get().getSaldo().add(valor.getValor()));
                Conta st = this.repository.save(conta.get());
                return mapper.map(st, ContaPessoalDTO.class);
            } else {
                throw new RuntimeException("Sem saldo Suficiente");
            }
        }
        throw new RuntimeException("Conta não encontrada");
    }
}
