package com.example.compassobank.controller;



import com.example.compassobank.dto.*;
import com.example.compassobank.service.ContaService;
import com.example.compassobank.service.ContaServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/conta",produces = "application/json")
public class ContaController {

    @Autowired
    private ContaServiceImpl service;

    @ApiOperation(value = "Faz um Saque")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Saque com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PatchMapping(path = "/{id}/saque")
    public ResponseEntity<ContaDTO> saque (@RequestParam(value = "id") Long id, @RequestBody OperacoesDTO body){
        return ResponseEntity.ok(this.service.saque(id,body));
    }

    @ApiOperation(value = "Faz um Deposito")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Deposito com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PatchMapping(path = "/{id}/deposito")
    public ResponseEntity<ContaDTO> deposito (@RequestParam(value = "id") Long id, @RequestBody OperacoesDTO body){
        return ResponseEntity.ok(this.service.deposito(id,body));
    }

    @ApiOperation(value = "Cria uma Conta")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Criado com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping
    public ResponseEntity<ContaDTO> salvar(@RequestBody ContaFormDTO body) {
        ContaDTO state = this.service.salvar(body);
        return ResponseEntity.ok(state);
    }

    @ApiOperation(value = "Procura uma Conta")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Procurado com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping(path = "/{id}")
    public ResponseEntity<ContaDTO> procurar (@RequestParam(value = "id") Long id){
        return ResponseEntity.ok(this.service.procurar(id));
    }

    @ApiOperation(value = "Atualiza uma Conta")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Atualizado com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PutMapping(path = "/{id}")
    public ResponseEntity<ContaDTO> atualizar (@RequestParam(value = "id") Long id, @RequestBody ContaFormDTO body){
        return ResponseEntity.ok(this.service.atualizar(id,body));
    }

    @ApiOperation(value = "Remove uma Conta")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Removido com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ContaDTO> remover (@RequestParam(value = "id") Long id){
        this.service.remover(id);
        return ResponseEntity.ok().build();
    }

}
