package com.example.compassobank.controllers;

import com.example.compassobank.dto.*;
import com.example.compassobank.services.ContaPessoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contaPessoal")
public class ContaPessoalController {

    @Autowired
    private ContaPessoalService service;

    @PatchMapping(path = "/{id}/saque")
    public ResponseEntity<ContaPessoalDTO> saque (@RequestParam(value = "id") Long id, @RequestBody OperacoesDTO body){
        return ResponseEntity.ok(this.service.saque(id,body));
    }

    @PatchMapping(path = "/{id}/deposito")
    public ResponseEntity<ContaPessoalDTO> deposito (@RequestParam(value = "id") Long id, @RequestBody OperacoesDTO body){
        return ResponseEntity.ok(this.service.deposito(id,body));
    }

    @PostMapping
    public ResponseEntity<ContaPessoalDTO> salvar(@RequestBody ContaPessoalFormDTO body) {
        ContaPessoalDTO state = this.service.salvar(body);
        return ResponseEntity.ok(state);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ContaPessoalDTO> procurar (@RequestParam(value = "id") Long id){
        return ResponseEntity.ok(this.service.procurar(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ContaPessoalDTO> atualizar (@RequestParam(value = "id") Long id, @RequestBody ContaPessoalFormDTO body){
        return ResponseEntity.ok(this.service.atualizar(id,body));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ContaPessoalDTO> remover (@RequestParam(value = "id") Long id){
        this.service.remover(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(path = "/{id}/tranferenciaInterna")
    public ResponseEntity<ContaPessoalDTO> transferenciaInterna (@RequestParam(value = "id") Long id, @RequestBody OperacoesDTO body, @RequestParam(value = "id") Long recebedor){
        return ResponseEntity.ok(this.service.transferenciaInterna(id,body,recebedor));
    }


    @PatchMapping(path = "/{id}/transferenciaExterna")
    public ResponseEntity<ContaPessoalDTO> transferenciaExterna (@RequestParam(value = "id") Long id, @RequestBody OperacoesDTO body){
        return ResponseEntity.ok(this.service.transferenciaExterna(id,body));
    }


    @PatchMapping(path = "/{id}/aplicarPoupanca")
    public ResponseEntity<ContaPessoalDTO> aplicarPoupanca (@RequestParam(value = "id") Long id, @RequestBody OperacoesDTO body){
        return ResponseEntity.ok(this.service.aplicarPoupanca(id,body));
    }

}