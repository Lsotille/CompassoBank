package com.example.compassobank.controllers;

import com.example.compassobank.dto.*;
import com.example.compassobank.services.GerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gerente")
public class GerenteController {


    @Autowired
    private GerenteService service;

    @PostMapping
    public ResponseEntity<GerenteDTO> salvar(@RequestBody GerenteFormDTO body) {
        GerenteDTO state = this.service.salvar(body);
        return ResponseEntity.ok(state);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<GerenteDTO> procurar (@RequestParam(value = "id") Long id){
        return ResponseEntity.ok(this.service.procurar(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<GerenteDTO> atualizar (@RequestParam(value = "id") Long id, @RequestBody GerenteFormDTO body){
        return ResponseEntity.ok(this.service.atualizar(id,body));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<GerenteDTO> remover (@RequestParam(value = "id") Long id){
        this.service.remover(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/{id}")
    public ResponseEntity<ContaDTO> aprovarconta(@RequestParam(value = "id")Long id){
        ContaDTO state = this.service.aprovarConta(id);
        return ResponseEntity.ok(state);
    }


    @PatchMapping(path = "/{id}/emprestimoPessoal")
    public ResponseEntity<ContaPessoalDTO> aprovarEmprestimoPessoal (@RequestParam(value = "id") Long id, @RequestBody OperacoesDTO body){
        return ResponseEntity.ok(this.service.aprovarEmprestimoPessoal(id,body));
    }

    @PatchMapping(path = "/{id}/emprestimoEmpresarial")
    public ResponseEntity<ContaEmpresarialDTO> aprovarEmprestimoEmpresarial (@RequestParam(value = "id") Long id, @RequestBody OperacoesDTO body){
        return ResponseEntity.ok(this.service.aprovarEmprestimoEmpresarial(id,body));
    }


    @PatchMapping(path ="/{id}/aprovarCheques")
    public ResponseEntity<ContaPessoalDTO> aprovarCheques(@RequestParam(value = "id") Long id, @RequestBody ChequesDTO body){
        return ResponseEntity.ok(this.service.aprovarCheques(id,body));
}

    @PatchMapping(path = "/{id}/modificarJuros")
    public ResponseEntity<ContaDTO> modificarJuros(@RequestParam(value = "id")Long id, @RequestBody OperacoesDTO body){
        return ResponseEntity.ok(this.service.modificarJuros(id,body));
    }

}
