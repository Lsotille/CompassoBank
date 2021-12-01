package com.example.compassobank.service;

import com.example.compassobank.dto.*;
import com.example.compassobank.entity.Agencia;
import com.example.compassobank.entity.Conta;
import com.example.compassobank.entity.ContaEmpresarial;
import com.example.compassobank.entity.ContaPessoal;
import com.example.compassobank.repository.AgenciaRepository;
import com.example.compassobank.repository.ContaEmpresarialRepository;
import com.example.compassobank.service.ContaEmpresarialService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.aspectj.runtime.internal.Conversions.floatValue;

@Service
public class ContaEmpresarialServiceImpl implements ContaEmpresarialService {

    @Autowired
    private ContaEmpresarialRepository repository;

    @Autowired
    private AgenciaRepository agenciaRepository;

    @Autowired
    private ModelMapper mapper;

    public ContaEmpresarialDTO saque(Long id, OperacoesDTO valor) {
        Optional<ContaEmpresarial> conta = this.repository.findById(id);
        Optional<Agencia> agencia = this.agenciaRepository.findById(conta.get().getAgencia());
        float saldo = floatValue(conta.get().getSaldo());
        float valorF = floatValue(valor.getValor());
        if (conta.isPresent()) {
            if (saldo > valorF) {
                conta.get().setSaldo(conta.get().getSaldo().subtract(valor.getValor()));
                agencia.get().setBalanco(agencia.get().getBalanco().subtract(valor.getValor()));
                Conta st = this.repository.save(conta.get());
                return mapper.map(st, ContaEmpresarialDTO.class);
            } else {
                throw new RuntimeException("Sem saldo Suficiente");
            }
        }
        throw new RuntimeException("Conta não encontrada");
    }


    @Override
    public ContaEmpresarialDTO deposito(Long id, OperacoesDTO valor) {
        Optional<ContaEmpresarial> conta = this.repository.findById(id);
        Optional<Agencia> agencia = this.agenciaRepository.findById(conta.get().getAgencia());
        if (conta.isPresent()) {
            conta.get().setSaldo(conta.get().getSaldo().add(valor.getValor()));
            agencia.get().setBalanco(agencia.get().getBalanco().add(valor.getValor()));
            Conta st = this.repository.save(conta.get());
            return mapper.map(st, ContaEmpresarialDTO.class);
        }
        throw new RuntimeException("Conta não encontrada");
    }

    @Override
    public ContaEmpresarialDTO salvar(ContaEmpresarialFormDTO body) {
        ContaEmpresarial conta = mapper.map(body, ContaEmpresarial.class);
        ContaEmpresarial contasResponse = this.repository.save(conta);
        return mapper.map(contasResponse, ContaEmpresarialDTO.class);
    }

    @Override
    public ContaEmpresarialDTO procurar(long id) {
        Optional<ContaEmpresarial> conta = this.repository.findById(id);
        if (conta.isPresent()) {
            return mapper.map(conta.get(), ContaEmpresarialDTO.class);
        }
        throw new RuntimeException("Conta não encontrada");
    }


    @Override
    public ContaEmpresarialDTO atualizar(long id, ContaEmpresarialFormDTO body) {
        Optional<ContaEmpresarial> conta = this.repository.findById(id);
        if (conta.isPresent()) {
            conta.get().setSenha(body.getSenha());
            Conta st = this.repository.save(conta.get());
            return mapper.map(st, ContaEmpresarialDTO.class);
        }
        throw new RuntimeException("Conta não encontrada");
    }

    @Override
    public void remover(Long id) {
        ContaEmpresarial conta = this.repository.findById(id).get();
        this.repository.delete(conta);

    }

    @Override
    public ContaEmpresarialDTO transferenciaExterna(Long id, OperacoesDTO valor) {
        Optional<ContaEmpresarial> conta = this.repository.findById(id);
        Optional<Agencia> agencia = this.agenciaRepository.findById(conta.get().getAgencia());
        float saldo = floatValue(conta.get().getSaldo());
        float valorF = floatValue(valor.getValor());
        if (conta.isPresent()) {
            if (saldo > valorF) {
                conta.get().setSaldo(conta.get().getSaldo().subtract(valor.getValor()));
                agencia.get().setBalanco(agencia.get().getBalanco().add(valor.getValor()));
                Conta st = this.repository.save(conta.get());
                return mapper.map(st, ContaEmpresarialDTO.class);
            } else {
                throw new RuntimeException("Sem saldo Suficiente");
            }
        }
        throw new RuntimeException("Conta não encontrada");
    }

    @Override
    public ContaEmpresarialDTO transferenciaInterna(Long id, OperacoesDTO valor, Long destinatario) {
        Optional<ContaEmpresarial> conta = this.repository.findById(id);
        Optional<ContaEmpresarial> recebedor = this.repository.findById(destinatario);
        float saldo = floatValue(conta.get().getSaldo());
        float valorF = floatValue(valor.getValor());
        if (conta.isPresent() && recebedor.isPresent()) {
            if (saldo > valorF) {
                conta.get().setSaldo(conta.get().getSaldo().subtract(valor.getValor()));
                Conta st = this.repository.save(conta.get());
                recebedor.get().setSaldo(recebedor.get().getSaldo().add(valor.getValor()));
                Conta st2 = this.repository.save(recebedor.get());
                return mapper.map(st, ContaEmpresarialDTO.class);
            } else {
                throw new RuntimeException("Sem saldo Suficiente");
            }
        }
        throw new RuntimeException("Conta não encontrada");
    }

    @Override
    public ContaEmpresarialDTO aplicarPoupanca(Long id, OperacoesDTO valor) {
        Optional<ContaEmpresarial> conta = this.repository.findById(id);
        float saldo = floatValue(conta.get().getSaldo());
        float valorF = floatValue(valor.getValor());
        if (conta.isPresent()) {
            if (saldo > valorF) {
                conta.get().setSaldo(conta.get().getSaldo().subtract(valor.getValor()));
                Conta st = this.repository.save(conta.get());
                return mapper.map(st, ContaEmpresarialDTO.class);
            } else {
                throw new RuntimeException("Saldo insuficiente para esta operação");
            }
        }
        throw new RuntimeException("Conta não encontrada");
    }

    @Override
    public ContaEmpresarialDTO pagarCredito(Long id) {
        Optional<ContaEmpresarial> conta = this.repository.findById(id);
        Optional<Agencia> agencia = this.agenciaRepository.findById(conta.get().getAgencia());
        float saldo = floatValue(conta.get().getSaldo());
        float credito = floatValue(conta.get().getCredito());
        if (conta.isPresent()) {
            if (saldo >= credito) {
                conta.get().setSaldo(conta.get().getSaldo().subtract(conta.get().getCredito()));
                conta.get().setCredito(conta.get().getCredito().subtract(conta.get().getCredito()));
                agencia.get().setBalanco(agencia.get().getBalanco().add(conta.get().getCredito()));
            }
            else {
                throw new RuntimeException("Saldo insuficiente para esta operação");
            }
        }
        throw new RuntimeException("Conta não encontrada");
    }
}
