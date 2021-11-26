package com.example.compassobank.service;


import com.example.compassobank.dto.AgenciaFormDTO;
import com.example.compassobank.dto.AgenciaDTO;
import com.example.compassobank.entity.Agencia;
import com.example.compassobank.repository.AgenciaRepository;
import com.example.compassobank.service.AgenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgenciaServiceImpl implements AgenciaService {

    @Autowired
    private AgenciaRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public AgenciaDTO salvar(AgenciaFormDTO body) {
        Agencia agencia = mapper.map(body, Agencia.class);
        Agencia agenciaResponse = this.repository.save(agencia);
        return mapper.map(agenciaResponse, AgenciaDTO.class);
    }

    @Override
    public AgenciaDTO procurar(Long id) {
        Optional<Agencia> agencia = this.repository.findById(id);
        if (agencia.isPresent()){
            return mapper.map(agencia.get(), AgenciaDTO.class);
        }
        throw new RuntimeException("Agencia não encontrada");
    }

    @Override
    public AgenciaDTO atualizar(Long id, AgenciaFormDTO body) {
        Optional<Agencia> agencia = this.repository.findById(id);
        if (agencia.isPresent()){
            agencia.get().setNomeDaAgencia(body.getNomeDaAgencia());
            agencia.get().setRegiao(body.getRegiao());
            agencia.get().setInstituicaoFinanceira(body.getInstituicaoFinanceira());
            Agencia st = this.repository.save(agencia.get());
            return mapper.map(st,AgenciaDTO.class);
        }
        throw new RuntimeException("Agencia não encontrada");
    }

    @Override
    public void remover(Long id) {
    Agencia agencia = this.repository.findById(id).get();
    this.repository.delete(agencia);
    }
}
