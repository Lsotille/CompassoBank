package com.example.compassobank.service;

import com.example.compassobank.dto.*;
import com.example.compassobank.entity.*;
import com.example.compassobank.repository.ContaEmpresarialRepository;
import com.example.compassobank.repository.ContaPessoalRepository;
import com.example.compassobank.repository.ContaRepository;
import com.example.compassobank.repository.GerenteRepository;
import com.example.compassobank.service.GerenteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GerenteServiceImpl implements GerenteService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private ContaPessoalRepository contaPessoalRepository;

    @Autowired
    private ContaEmpresarialRepository contaEmpresarialRepository;

    @Autowired
    private GerenteRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public GerenteDTO salvar(GerenteFormDTO body) {
        Gerente gerente = mapper.map(body, Gerente.class);
        Gerente gerenteResponse =  this.repository.save(gerente);
        return mapper.map(gerenteResponse, GerenteDTO.class)        ;
    }

    @Override
    public GerenteDTO procurar(Long id) {
        Optional<Gerente> state = this.repository.findById(id);
        if (state.isPresent()) {
            return mapper.map(state.get(), GerenteDTO.class);
        }
        throw new RuntimeException("Gerente não localizado");
    }

    @Override
    public GerenteDTO atualizar(Long id, GerenteFormDTO body) {
        Optional<Gerente> gerente = this.repository.findById(id);
        if (gerente.isPresent()) {
            Gerente st = this.repository.save(gerente.get());
            return mapper.map(st, GerenteDTO.class);
        }
        throw new RuntimeException("Gerente não localizado");
    }


    @Override
    public void remover(Long id) {
        Gerente gerente = this.repository.findById(id).get();
        this.repository.delete(gerente);
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
    public ContaPessoalDTO aprovarCheques(Long id, ChequesDTO valor) {
        Optional<ContaPessoal> conta = this.contaPessoalRepository.findById(id);
        if (conta.isPresent()){
            conta.get().setCheques(conta.get().getCheques()+(valor.getValor()));
            Conta st = this.contaPessoalRepository.save(conta.get());
            return mapper.map(st, ContaPessoalDTO.class);
        }
        throw new RuntimeException("Conta não encontrada");
    }

    @Override
    public ContaDTO modificarJuros(Long id, OperacoesDTO body) {
        Optional<Conta> conta = this.contaRepository.findById(id);
        if (conta.isPresent()) {
            conta.get().setJuros(body.getValor());
            Conta st = this.contaRepository.save(conta.get());
            return mapper.map(st, ContaDTO.class);
        }
        throw new RuntimeException("Conta não encontrada");
    }

}


