package com.example.compassobank.controller;

import com.example.compassobank.dto.*;
import com.example.compassobank.service.ContaPessoalService;
import com.example.compassobank.service.ContaPessoalServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/contaPessoal",produces = "application/json")
public class ContaPessoalController {

    @Autowired
    private ContaPessoalServiceImpl service;

    @ApiOperation(value = "Faz um Saque")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Saque com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PatchMapping(path = "/{id}/saque")
    public ResponseEntity<ContaPessoalDTO> saque (@RequestParam(value = "id") Long id, @RequestBody OperacoesDTO body){
        return ResponseEntity.ok(this.service.saque(id,body));
    }

    @ApiOperation(value = "Faz um Deposito")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Deposito com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PatchMapping(path = "/{id}/deposito")
    public ResponseEntity<ContaPessoalDTO> deposito (@RequestParam(value = "id") Long id, @RequestBody OperacoesDTO body){
        return ResponseEntity.ok(this.service.deposito(id,body));
    }

    @ApiOperation(value = "Cadastra uma Conta Pessoal")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cadastrado com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping
    public ResponseEntity<ContaPessoalDTO> salvar(@RequestBody ContaPessoalFormDTO body) {
        ContaPessoalDTO state = this.service.salvar(body);
        return ResponseEntity.ok(state);
    }

    @ApiOperation(value = "Procura uma Conta Pessoal")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Procurado com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping(path = "/{id}")
    public ResponseEntity<ContaPessoalDTO> procurar (@RequestParam(value = "id") Long id){
        return ResponseEntity.ok(this.service.procurar(id));
    }

    @ApiOperation(value = "Atualiza uma Conta Pessoal")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Atualizado com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PutMapping(path = "/{id}")
    public ResponseEntity<ContaPessoalDTO> atualizar (@RequestParam(value = "id") Long id, @RequestBody ContaPessoalFormDTO body){
        return ResponseEntity.ok(this.service.atualizar(id,body));
    }

    @ApiOperation(value = "Remove uma Conta Pessoal")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Removido com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ContaPessoalDTO> remover (@RequestParam(value = "id") Long id){
        this.service.remover(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Tranferencia Interna")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Tranferido com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PatchMapping(path = "/{id}/tranferenciaInterna")
    public ResponseEntity<ContaPessoalDTO> transferenciaInterna (@RequestParam(value = "id") Long id, @RequestBody OperacoesDTO body, @RequestParam(value = "id") Long recebedor){
        return ResponseEntity.ok(this.service.transferenciaInterna(id,body,recebedor));
    }


    @ApiOperation(value = "Transferencia Externa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Transferido com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PatchMapping(path = "/{id}/transferenciaExterna")
    public ResponseEntity<ContaPessoalDTO> transferenciaExterna (@RequestParam(value = "id") Long id, @RequestBody OperacoesDTO body){
        return ResponseEntity.ok(this.service.transferenciaExterna(id,body));
    }


    @ApiOperation(value = "Aplica Poupanca")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Aplicado com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PatchMapping(path = "/{id}/aplicarPoupanca")
    public ResponseEntity<ContaPessoalDTO> aplicarPoupanca (@RequestParam(value = "id") Long id, @RequestBody OperacoesDTO body){
        return ResponseEntity.ok(this.service.aplicarPoupanca(id,body));
    }

    @ApiOperation(value = "Paga Credito")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pago com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PatchMapping(path = "/{id}/pagarCredito")
    public ResponseEntity<ContaPessoalDTO> pagarCredito (@RequestParam(value = "id") Long id){
        return ResponseEntity.ok(this.service.pagarCredito(id));
    }

}
