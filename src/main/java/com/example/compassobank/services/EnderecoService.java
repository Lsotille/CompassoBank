package com.example.compassobank.services;


import com.example.compassobank.dto.EnderecoDTO;
import com.example.compassobank.dto.EnderecoFormDTO;

import java.util.List;

public interface EnderecoService {


    EnderecoDTO salvar(EnderecoFormDTO body);

    List<EnderecoDTO> listar();

    EnderecoDTO procurar(Long id);

    EnderecoDTO atualizar(Long id, EnderecoFormDTO body);

    void remover(Long id);

}
