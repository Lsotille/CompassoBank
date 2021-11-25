package com.example.compassobank.services;

import com.example.compassobank.dto.*;
import com.example.compassobank.entity.*;
import com.example.compassobank.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


public class DiretorServiceImpl implements DiretorService{
    @Autowired
    private ContaPessoalRepository pessoalRepository;

    @Autowired
    private ContaEmpresarialRepository empresarialRepository;

    @Autowired
    private BanqueiroRepository banqueiroRepository;

    @Autowired
    private GerenteRepository gerenteRepository;

    @Autowired
    private DiretorRepository repository;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public DiretorDTO salvar(DiretorFormDTO body) {
        Diretor diretor  = mapper.map(body, Diretor.class);
        Diretor diretorResponse =  this.repository.save(diretor);
        return mapper.map(diretorResponse, DiretorDTO.class)        ;
    }

    @Override
    public DiretorDTO procurar(Long id) {
        Optional<Diretor> state = this.repository.findById(id);
        if (state.isPresent()) {
            return mapper.map(state.get(), DiretorDTO.class);
        }
        throw new RuntimeException("Diretor não localizado");
    }

    @Override
    public DiretorDTO atualizar(Long id, DiretorFormDTO body) {
        Optional<Diretor> diretor = this.repository.findById(id);
        if (diretor.isPresent()) {
            Gerente st = this.repository.save(diretor.get());
            return mapper.map(st, DiretorDTO.class);
        }
        throw new RuntimeException("Diretor não localizado");
    }


    @Override
    public void remover(Long id) {
        Diretor diretor = this.repository.findById(id).get();
        this.repository.delete(diretor);
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
        Optional<ContaPessoal> conta = this.pessoalRepository.findById(id);
        if (conta.isPresent()) {
            conta.get().setSaldo(conta.get().getSaldo().add(body.getValor()));
            conta.get().setCredito(conta.get().getCredito().add(body.getValor()));
            ContaPessoal st = this.pessoalRepository.save(conta.get());
            return mapper.map(st, ContaPessoalDTO.class);
        }
        throw new RuntimeException("Conta não encontrada");
    }

    @Override
    public ContaEmpresarialDTO aprovarEmprestimoEmpresarial(Long id, OperacoesDTO body) {
        Optional<ContaEmpresarial> conta = this.empresarialRepository.findById(id);
        if (conta.isPresent()) {
            conta.get().setSaldo(conta.get().getSaldo().add(body.getValor()));
            conta.get().setCredito(conta.get().getCredito().add(body.getValor()));
            ContaEmpresarial st = this.empresarialRepository.save(conta.get());
            return mapper.map(st, ContaEmpresarialDTO.class);
        }
        throw new RuntimeException("Conta não encontrada");
    }

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

    @Override
    public BanqueiroDTO promoverBanqueiro(Long id) {
        Optional<Banqueiro> banqueiro = this.banqueiroRepository.findById(id);
        if (banqueiro.isPresent()){
            banqueiro.get().setCargo("Gerente");
            Banqueiro st = this.banqueiroRepository.save(banqueiro.get());
            return mapper.map(st, BanqueiroDTO.class);
        }
        throw new RuntimeException("Banqueiro não encontrado");
    }

    @Override
    public GerenteDTO promoverGerente(Long id) {
        Optional<Gerente> gerente = this.gerenteRepository.findById(id);
        if (gerente.isPresent()){
            gerente.get().setCargo("Diretor");
            Banqueiro st = this.gerenteRepository.save(gerente.get());
            return mapper.map(st, GerenteDTO.class);
        }
        throw new RuntimeException("Gerente não encontrado");
    }
}
