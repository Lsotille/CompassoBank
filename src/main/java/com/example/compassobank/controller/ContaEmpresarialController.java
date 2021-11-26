package com.example.compassobank.controller;


import com.example.compassobank.dto.ContaEmpresarialDTO;
import com.example.compassobank.dto.ContaEmpresarialFormDTO;
import com.example.compassobank.dto.OperacoesDTO;
import com.example.compassobank.service.ContaEmpresarialService;
import com.example.compassobank.service.ContaEmpresarialServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contaEmpresarial")
public class ContaEmpresarialController {


    @Autowired
    private ContaEmpresarialServiceImpl service;

    @PatchMapping(path = "/{id}/saque")
    public ResponseEntity<ContaEmpresarialDTO> saque (@RequestParam(value = "id") Long id, @RequestBody OperacoesDTO body){
        return ResponseEntity.ok(this.service.saque(id,body));
    }

    @PatchMapping(path = "/{id}/deposito")
    public ResponseEntity<ContaEmpresarialDTO> deposito (@RequestParam(value = "id") Long id, @RequestBody OperacoesDTO body){
        return ResponseEntity.ok(this.service.deposito(id,body));
    }

    @PostMapping
    public ResponseEntity<ContaEmpresarialDTO> salvar(@RequestBody ContaEmpresarialFormDTO body) {
        ContaEmpresarialDTO state = this.service.salvar(body);
        return ResponseEntity.ok(state);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ContaEmpresarialDTO> procurar (@RequestParam(value = "id") Long id){
        return ResponseEntity.ok(this.service.procurar(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ContaEmpresarialDTO> atualizar (@RequestParam(value = "id") Long id, @RequestBody ContaEmpresarialFormDTO body){
        return ResponseEntity.ok(this.service.atualizar(id,body));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ContaEmpresarialDTO> remover (@RequestParam(value = "id") Long id){
        this.service.remover(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(path = "/{id}/tranferenciaInterna")
    public ResponseEntity<ContaEmpresarialDTO> transferenciaInterna (@RequestParam(value = "id") Long id, @RequestBody OperacoesDTO body, @RequestParam(value = "id") Long recebedor){
        return ResponseEntity.ok(this.service.transferenciaInterna(id,body,recebedor));
    }


    @PatchMapping(path = "/{id}/transferenciaExterna")
    public ResponseEntity<ContaEmpresarialDTO> transferenciaExterna (@RequestParam(value = "id") Long id, @RequestBody OperacoesDTO body){
        return ResponseEntity.ok(this.service.transferenciaExterna(id,body));
    }


    @PatchMapping(path = "/{id}/aplicarPoupanca")
    public ResponseEntity<ContaEmpresarialDTO> aplicarPoupanca (@RequestParam(value = "id") Long id, @RequestBody OperacoesDTO body){
        return ResponseEntity.ok(this.service.aplicarPoupanca(id,body));
    }

    @PatchMapping(path = "/{id}/pagarCredito")
    public ResponseEntity<ContaEmpresarialDTO> pagarCredito (@RequestParam(value = "id") Long id){
        return ResponseEntity.ok(this.service.pagarCredito(id));
    }

}
