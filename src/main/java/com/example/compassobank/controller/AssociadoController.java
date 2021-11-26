package com.example.compassobank.controller;

import com.example.compassobank.dto.AssociadoDTO;
import com.example.compassobank.dto.AssociadoFormDTO;
import com.example.compassobank.service.AssociadoService;
import com.example.compassobank.service.AssociadoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/associado")
public class AssociadoController {

    @Autowired
    private AssociadoServiceImpl service;

    @PostMapping
    public ResponseEntity<AssociadoDTO> salvar(@RequestBody AssociadoFormDTO body) {
        AssociadoDTO state = this.service.salvar(body);
        return ResponseEntity.ok(state);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AssociadoDTO> procurar (@RequestParam(value = "id") Long id){
        return ResponseEntity.ok(this.service.procurar(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<AssociadoDTO> atualizar (@RequestParam(value = "id") Long id, @RequestBody AssociadoFormDTO body){
        return ResponseEntity.ok(this.service.atualizar(id,body));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<AssociadoDTO> remover (@RequestParam(value = "id") Long id){
        this.service.remover(id);
        return ResponseEntity.ok().build();
    }

}
