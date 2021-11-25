package com.example.compassobank.services;


import com.example.compassobank.dto.EnderecoDTO;
import com.example.compassobank.dto.EnderecoFormDTO;
import com.example.compassobank.entity.Endereco;
import com.example.compassobank.repository.EnderecoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EnderecoServiceImpl implements EnderecoService{

    @Autowired
    private EnderecoRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public EnderecoDTO salvar(EnderecoFormDTO body) {
        Endereco endereco = mapper.map(body, Endereco.class);
        Endereco enderecoResponse =  this.repository.save(endereco);
        return mapper.map(enderecoResponse, EnderecoDTO.class)        ;
    }


    @Override
    public EnderecoDTO procurar(Long id) {
        Optional<Endereco> state = this.repository.findById(id);
        if (state.isPresent()) {
            return mapper.map(state.get(), EnderecoDTO.class);
        }
        throw new RuntimeException("Endereco não localizado");
    }

    @Override
    public EnderecoDTO atualizar(Long id, EnderecoFormDTO body) {
        Optional<Endereco> endereco = this.repository.findById(id);
        if (endereco.isPresent() == true) {
            Endereco st = this.repository.save(endereco.get());
            return mapper.map(st, EnderecoDTO.class);
        }
        throw new RuntimeException("Endereco não localizado");
    }

    @Override
    public void remover(Long id) {
        Endereco endereco = this.repository.findById(id).get();
        this.repository.delete(endereco);
    }
}
