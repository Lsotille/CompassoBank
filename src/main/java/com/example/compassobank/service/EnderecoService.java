package com.example.compassobank.service;


import com.example.compassobank.dto.EnderecoDTO;
import com.example.compassobank.dto.EnderecoFormDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public interface EnderecoService {


    EnderecoDTO salvar(EnderecoFormDTO body);

    EnderecoDTO procurar(Long id);

    EnderecoDTO atualizar(Long id, EnderecoFormDTO body);

    void remover(Long id);

}
