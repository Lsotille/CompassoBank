package com.example.compassobank.controller;



import com.example.compassobank.dto.*;
import com.example.compassobank.service.ContaService;
import com.example.compassobank.service.ContaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private ContaServiceImpl service;

    @PatchMapping(path = "/{id}/saque")
    public ResponseEntity<ContaDTO> saque (@RequestParam(value = "id") Long id, @RequestBody OperacoesDTO body){
        return ResponseEntity.ok(this.service.saque(id,body));
    }

    @PatchMapping(path = "/{id}/deposito")
    public ResponseEntity<ContaDTO> deposito (@RequestParam(value = "id") Long id, @RequestBody OperacoesDTO body){
        return ResponseEntity.ok(this.service.deposito(id,body));
    }

    @PostMapping
    public ResponseEntity<ContaDTO> salvar(@RequestBody ContaFormDTO body) {
        ContaDTO state = this.service.salvar(body);
        return ResponseEntity.ok(state);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ContaDTO> procurar (@RequestParam(value = "id") Long id){
        return ResponseEntity.ok(this.service.procurar(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ContaDTO> atualizar (@RequestParam(value = "id") Long id, @RequestBody ContaFormDTO body){
        return ResponseEntity.ok(this.service.atualizar(id,body));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ContaDTO> remover (@RequestParam(value = "id") Long id){
        this.service.remover(id);
        return ResponseEntity.ok().build();
    }

}
