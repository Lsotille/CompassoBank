package com.example.compassobank.service;

import com.example.compassobank.dto.AssociadoDTO;
import com.example.compassobank.dto.AssociadoFormDTO;
import com.example.compassobank.entity.Associado;
import com.example.compassobank.repository.AssociadoRepository;
import com.example.compassobank.service.AssociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssociadoServiceImpl implements AssociadoService {

    @Autowired
    private AssociadoRepository repository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public AssociadoDTO salvar(AssociadoFormDTO body) {
        Associado associados = mapper.map(body, Associado.class);
        Associado associadosResponse = this.repository.save(associados);
        return mapper.map(associadosResponse, AssociadoDTO.class);
    }

    @Override
    public AssociadoDTO procurar(Long id) {
        Optional<Associado> associado = this.repository.findById(id);
        if (associado.isPresent()) {
            return mapper.map(associado.get(), AssociadoDTO.class);
        }
        throw new RuntimeException("Associado não encontrado");
    }

    @Override
    public AssociadoDTO atualizar(Long id, AssociadoFormDTO body) {
        Optional<Associado> associado = this.repository.findById(id);
        if (associado.isPresent()) {
            associado.get().setNome(body.getNome());
            associado.get().setTrabalho(body.getTrabalho());
            associado.get().setCpf(body.getCpf());
            associado.get().setCnpj(body.getCnpj());
            associado.get().setIdade(body.getIdade());
            Associado st = this.repository.save(associado.get());
            return mapper.map(st, AssociadoDTO.class);
        }
        throw new RuntimeException("Associado não encontrado");
    }

    @Override
    public void remover(Long id) {
        Associado associado = this.repository.findById(id).get();
        this.repository.delete(associado);

    }
}
