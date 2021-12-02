package com.example.compassobank.controller;


import com.example.compassobank.dto.ContaEmpresarialDTO;
import com.example.compassobank.dto.ContaEmpresarialFormDTO;
import com.example.compassobank.dto.OperacoesDTO;
import com.example.compassobank.service.ContaEmpresarialService;
import com.example.compassobank.service.ContaEmpresarialServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/contaEmpresarial",produces = "application/json")
public class ContaEmpresarialController {


    @Autowired
    private ContaEmpresarialServiceImpl service;

    @ApiOperation(value = "Faz um Saque")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Saque com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PatchMapping(path = "/{id}/saque")
    public ResponseEntity<ContaEmpresarialDTO> saque (@RequestParam(value = "id") Long id, @RequestBody OperacoesDTO body){
        return ResponseEntity.ok(this.service.saque(id,body));
    }

    @ApiOperation(value = "Faz um Deposito")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Deposito com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PatchMapping(path = "/{id}/deposito")
    public ResponseEntity<ContaEmpresarialDTO> deposito (@RequestParam(value = "id") Long id, @RequestBody OperacoesDTO body){
        return ResponseEntity.ok(this.service.deposito(id,body));
    }

    @ApiOperation(value = "Cadastra uma Conta Empresarial")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cadastrado com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping
    public ResponseEntity<ContaEmpresarialDTO> salvar(@RequestBody ContaEmpresarialFormDTO body) {
        ContaEmpresarialDTO state = this.service.salvar(body);
        return ResponseEntity.ok(state);
    }

    @ApiOperation(value = "Procura uma Conta Empresarial")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Procurado com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping(path = "/{id}")
    public ResponseEntity<ContaEmpresarialDTO> procurar (@RequestParam(value = "id") Long id){
        return ResponseEntity.ok(this.service.procurar(id));
    }

    @ApiOperation(value = "Atualiza uma Conta Empresarial")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Atualizado com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PutMapping(path = "/{id}")
    public ResponseEntity<ContaEmpresarialDTO> atualizar (@RequestParam(value = "id") Long id, @RequestBody ContaEmpresarialFormDTO body){
        return ResponseEntity.ok(this.service.atualizar(id,body));
    }

    @ApiOperation(value = "Remove uma Conta Empresarial")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Removido com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ContaEmpresarialDTO> remover (@RequestParam(value = "id") Long id){
        this.service.remover(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Tranferencia Interna")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Tranferido com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PatchMapping(path = "/{id}/tranferenciaInterna")
    public ResponseEntity<ContaEmpresarialDTO> transferenciaInterna (@RequestParam(value = "id") Long id, @RequestBody OperacoesDTO body, @RequestParam(value = "id") Long recebedor){
        return ResponseEntity.ok(this.service.transferenciaInterna(id,body,recebedor));
    }

    @ApiOperation(value = "Transferencia Externa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Transferido com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PatchMapping(path = "/{id}/transferenciaExterna")
    public ResponseEntity<ContaEmpresarialDTO> transferenciaExterna (@RequestParam(value = "id") Long id, @RequestBody OperacoesDTO body){
        return ResponseEntity.ok(this.service.transferenciaExterna(id,body));
    }


    @ApiOperation(value = "Aplica Poupanca")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Aplicado com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PatchMapping(path = "/{id}/aplicarPoupanca")
    public ResponseEntity<ContaEmpresarialDTO> aplicarPoupanca (@RequestParam(value = "id") Long id, @RequestBody OperacoesDTO body){
        return ResponseEntity.ok(this.service.aplicarPoupanca(id,body));
    }

    @ApiOperation(value = "Paga Credito")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pago com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PatchMapping(path = "/{id}/pagarCredito")
    public ResponseEntity<ContaEmpresarialDTO> pagarCredito (@RequestParam(value = "id") Long id){
        return ResponseEntity.ok(this.service.pagarCredito(id));
    }

}
