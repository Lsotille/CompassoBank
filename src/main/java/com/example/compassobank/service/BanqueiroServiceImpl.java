package com.example.compassobank.service;

import com.example.compassobank.dto.*;
import com.example.compassobank.entity.*;
import com.example.compassobank.repository.BanqueiroRepository;
import com.example.compassobank.repository.ContaEmpresarialRepository;
import com.example.compassobank.repository.ContaPessoalRepository;
import com.example.compassobank.repository.ContaRepository;
import com.example.compassobank.service.BanqueiroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

import static org.aspectj.runtime.internal.Conversions.floatValue;

@Service
public class BanqueiroServiceImpl implements BanqueiroService {

    @Autowired
    private BanqueiroRepository repository;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private ContaPessoalRepository contaPessoalRepository;

    @Autowired
    private ContaEmpresarialRepository contaEmpresarialRepository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public BanqueiroDTO salvar(BanqueiroFormDTO body) {
        Banqueiro banqueiro = mapper.map(body, Banqueiro.class);
        Banqueiro banqueiroResponse =  this.repository.save(banqueiro);
        return mapper.map(banqueiroResponse, BanqueiroDTO.class)        ;
    }

    @Override
    public BanqueiroDTO procurar(Long id) {
        Optional<Banqueiro> state = this.repository.findById(id);
        if (state.isPresent()) {
            return mapper.map(state.get(), BanqueiroDTO.class);
        }
        throw new RuntimeException("Banqueiro não localizado");
    }

    @Override
    public BanqueiroDTO atualizar(Long id, BanqueiroFormDTO body) {
        Optional<Banqueiro> banqueiro = this.repository.findById(id);
        if (banqueiro.isPresent()) {
            Banqueiro st = this.repository.save(banqueiro.get());
            return mapper.map(st, BanqueiroDTO.class);
        }
        throw new RuntimeException("Banqueiro não localizado");
    }


    @Override
    public void remover(Long id) {
        Banqueiro banqueiro = this.repository.findById(id).get();
        this.repository.delete(banqueiro);
    }

    @Override
    public ContaDTO aprovarConta(Long id) {
        Optional<Conta> conta = this.contaRepository.findById(id);
        if (conta.isPresent()) {
            conta.get().setAtivo(true);
            Conta st = this.contaRepository.save(conta.get());
            return mapper.map(st, ContaDTO.class);
        }
        throw new RuntimeException("Conta não encontrada");
    }


    @Override
    public ContaPessoalDTO aprovarEmprestimoPessoal(Long id, OperacoesDTO body) {
        Optional<ContaPessoal> conta = this.contaPessoalRepository.findById(id);
        if (conta.isPresent()) {
            conta.get().setSaldo(conta.get().getSaldo().add(body.getValor()));
            conta.get().setCredito(conta.get().getCredito().add(body.getValor()));
            ContaPessoal st = this.contaPessoalRepository.save(conta.get());
            return mapper.map(st, ContaPessoalDTO.class);
        }
        throw new RuntimeException("Conta não encontrada");
    }

    @Override
    public ContaEmpresarialDTO aprovarEmprestimoEmpresarial(Long id, OperacoesDTO body) {
        Optional<ContaEmpresarial> conta = this.contaEmpresarialRepository.findById(id);
        if (conta.isPresent()) {
            conta.get().setSaldo(conta.get().getSaldo().add(body.getValor()));
            conta.get().setCredito(conta.get().getCredito().add(body.getValor()));
            ContaEmpresarial st = this.contaEmpresarialRepository.save(conta.get());
            return mapper.map(st, ContaEmpresarialDTO.class);
        }
        throw new RuntimeException("Conta não encontrada");
    }

    @Override
    public ContaDTO saldoParaMoedaEstrangeira(Long id, OperacoesDTO valor) {
        Optional<Conta> conta = this.contaRepository.findById(id);
        float saldo = floatValue(conta.get().getSaldo());
        float valorD = floatValue(valor.getValor());
        float valorR = (float) (valorD * 5.55);
        BigDecimal multi = new BigDecimal(5.55);
        if (conta.isPresent()) {
            if (saldo > valorR) {
                conta.get().setSaldo(conta.get().getSaldo().subtract(valor.getValor().multiply(multi)));
                Conta st = this.contaRepository.save(conta.get());
                return mapper.map(st, ContaDTO.class);
            } else {
                throw new RuntimeException("Sem saldo Suficiente");
            }
        }
        throw new RuntimeException("Conta não encontrada");
    }
}
