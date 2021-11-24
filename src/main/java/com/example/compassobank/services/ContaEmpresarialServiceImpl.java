package com.example.compassobank.services;

import com.example.compassobank.dto.ContaEmpresarialDTO;
import com.example.compassobank.dto.ContaEmpresarialFormDTO;
import com.example.compassobank.dto.OperacoesDTO;
import com.example.compassobank.entity.ContaEmpresarial;
import com.example.compassobank.repository.ContaEmpresarialRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.aspectj.runtime.internal.Conversions.floatValue;

public class ContaEmpresarialServiceImpl implements ContaEmpresarialService{

    @Autowired
    private ContaEmpresarialRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ContaEmpresarialDTO saque(Long id, OperacoesDTO valor) {
        return null;
    }

    @Override
    public ContaEmpresarialDTO deposito(Long id, OperacoesDTO valor) {
        return null;
    }

    @Override
    public ContaEmpresarialDTO salvar(ContaEmpresarialFormDTO body) {
        return null;
    }

    @Override
    public ContaEmpresarialDTO procurar(long id) {
        return null;
    }

    @Override
    public ContaEmpresarialDTO atualizar(long id, ContaEmpresarialFormDTO body) {
        return null;
    }

    @Override
    public void remover(Long id) {

    }

    @Override
    public ContaEmpresarialDTO transferenciaExterna(Long id, OperacoesDTO valor) {
        return null;
    }

    @Override
    public ContaEmpresarialDTO transferenciaInterna(Long id, OperacoesDTO valor, Long destinatario) {
        return null;
    }

    @Override
    public ContaEmpresarialDTO aplicarPoupanca(Long id, OperacoesDTO valor) {
        return null;
    }

    @Override
    public ContaEmpresarialDTO pagarCredito(Long id) {
        Optional<ContaEmpresarial> conta = this.repository.findById(id);
        float saldo = floatValue(conta.get().getSaldo());
        float credito = floatValue(conta.get().getCredito());
        if (conta.isPresent()) {
            if (saldo >= credito) {
                conta.get().setSaldo(conta.get().getSaldo().subtract(conta.get().getCredito()));
                conta.get().setCredito(conta.get().getCredito().subtract(conta.get().getCredito()));
            }
            else {
                throw new RuntimeException("Saldo insuficiente para esta operação");
            }
        }
        throw new RuntimeException("Conta não encontrada");
    }
}
