package com.example.compassobank.services;


import com.example.compassobank.dto.*;
import org.springframework.stereotype.Service;

@Service
public interface GerenteService {


    ContaPessoalDTO aprovarCheques(Long id, ChequesDTO valor);

}
