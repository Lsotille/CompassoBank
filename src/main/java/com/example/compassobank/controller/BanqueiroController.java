package com.example.compassobank.controller;

import com.example.compassobank.dto.*;
import com.example.compassobank.service.BanqueiroService;
import com.example.compassobank.service.BanqueiroServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/banqueiro",produces = "application/json")
public class BanqueiroController {


    @Autowired
    private BanqueiroServiceImpl service;


    @ApiOperation(value = "Cria um Banqueiro")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Criado com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping
    public ResponseEntity<BanqueiroDTO> salvar(@RequestBody BanqueiroFormDTO body) {
        BanqueiroDTO state = this.service.salvar(body);
        return ResponseEntity.ok(state);
    }


    @ApiOperation(value = "Procura um Banqueiro")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Procurado com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping(path = "/{id}")
    public ResponseEntity<BanqueiroDTO> procurar (@RequestParam(value = "id") Long id){
        return ResponseEntity.ok(this.service.procurar(id));
    }

    @ApiOperation(value = "Atualiza um Banqueiro")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Atualiza com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PutMapping(path = "/{id}")
    public ResponseEntity<BanqueiroDTO> atualizar (@RequestParam(value = "id") Long id, @RequestBody BanqueiroFormDTO body){
        return ResponseEntity.ok(this.service.atualizar(id,body));
    }

    @ApiOperation(value = "Remove um Banqueiro")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Removido com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<BanqueiroDTO> remover (@RequestParam(value = "id") Long id){
        this.service.remover(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Aprova uma Conta")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Aprovado com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping(path = "/{id}")
    public ResponseEntity<ContaDTO> aprovarconta(@RequestParam(value = "id")Long id){
        ContaDTO state = this.service.aprovarConta(id);
        return ResponseEntity.ok(state);
    }

    @ApiOperation(value = "Emprestimo Pessoal")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Emprestimo com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PatchMapping(path = "/{id}/emprestimoPessoal")
    public ResponseEntity<ContaPessoalDTO> aprovarEmprestimoPessoal (@RequestParam(value = "id") Long id, @RequestBody OperacoesDTO body){
        return ResponseEntity.ok(this.service.aprovarEmprestimoPessoal(id,body));
    }

    @ApiOperation(value = "Emprestimo Empresarial")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Emprestimo com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PatchMapping(path = "/{id}/emprestimoEmpresarial")
    public ResponseEntity<ContaEmpresarialDTO> aprovarEmprestimoEmpresarial (@RequestParam(value = "id") Long id, @RequestBody OperacoesDTO body){
        return ResponseEntity.ok(this.service.aprovarEmprestimoEmpresarial(id,body));
    }

    @ApiOperation(value = "Comprar Moeda Estrangeira")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cambio com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PatchMapping(path = "/{id}/saldoParaMoedaEstrangeira")
    public ResponseEntity<ContaDTO> saldoParaMoedaEstrangeira (@RequestParam(value = "id") Long id, @RequestBody OperacoesDTO body){
        return ResponseEntity.ok(this.service.saldoParaMoedaEstrangeira(id,body));
    }

    @ApiOperation(value = "Vende Moeda Estrangeira")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cambio com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PatchMapping(path = "/{id}/moedaEstrangeiraParaSaldo")
    public ResponseEntity<ContaDTO> moedaEstrangeiraParaSaldo (@RequestParam(value = "id") Long id, @RequestBody OperacoesDTO body){
        return ResponseEntity.ok(this.service.moedaEstrangeiraParaSaldo(id,body));
    }

}
