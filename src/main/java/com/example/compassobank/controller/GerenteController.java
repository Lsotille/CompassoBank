package com.example.compassobank.controller;

import com.example.compassobank.dto.*;
import com.example.compassobank.service.GerenteService;
import com.example.compassobank.service.GerenteServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/gerente",produces = "application/json")
public class GerenteController {


    @Autowired
    private GerenteServiceImpl service;

    @ApiOperation(value = "Cria um Gerente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Criado com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping
    public ResponseEntity<GerenteDTO> salvar(@RequestBody GerenteFormDTO body) {
        GerenteDTO state = this.service.salvar(body);
        return ResponseEntity.ok(state);
    }

    @ApiOperation(value = "Procura um Gerente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Procurado com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping(path = "/{id}")
    public ResponseEntity<GerenteDTO> procurar (@RequestParam(value = "id") Long id){
        return ResponseEntity.ok(this.service.procurar(id));
    }

    @ApiOperation(value = "Atualiza um Gerente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Atualiza com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PutMapping(path = "/{id}")
    public ResponseEntity<GerenteDTO> atualizar (@RequestParam(value = "id") Long id, @RequestBody GerenteFormDTO body){
        return ResponseEntity.ok(this.service.atualizar(id,body));
    }

    @ApiOperation(value = "Remove um Gerente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Removido com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<GerenteDTO> remover (@RequestParam(value = "id") Long id){
        this.service.remover(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/{id}/aprovarFuncionario")
    public ResponseEntity<BanqueiroDTO> aprovarFuncionario(@RequestParam(value = "id")Long id){
        BanqueiroDTO state = this.service.aprovarFuncionario(id);
        return ResponseEntity.ok(state);
    }

    @PatchMapping(path = "/{id}/expandirLimitePessoal")
    public ResponseEntity<ContaPessoalDTO> expandirLimitePessoal(@RequestParam(value = "id")Long id, @RequestBody OperacoesDTO body){
        return ResponseEntity.ok(this.service.expandirLimitePessoal(id,body));
    }

    @PatchMapping(path = "/{id}/expandirLimiteEmpresarial")
    public ResponseEntity<ContaEmpresarialDTO> expandirLimiteEmpresarial(@RequestParam(value = "id")Long id, @RequestBody OperacoesDTO body){
        return ResponseEntity.ok(this.service.expandirLimiteEmpresarial(id,body));
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

    @ApiOperation(value = "Aprovar Cheques")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Aprovado com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PatchMapping(path ="/{id}/aprovarCheques")
    public ResponseEntity<ContaPessoalDTO> aprovarCheques(@RequestParam(value = "id") Long id, @RequestBody ChequesDTO body){
        return ResponseEntity.ok(this.service.aprovarCheques(id,body));
    }

    @ApiOperation(value = "Modifica os Juros")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Juros Modificados com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PatchMapping(path = "/{id}/modificarJuros")
    public ResponseEntity<ContaDTO> modificarJuros(@RequestParam(value = "id")Long id, @RequestBody OperacoesDTO body){
        return ResponseEntity.ok(this.service.modificarJuros(id,body));
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

    @ApiOperation(value = "Trocar Moeda Estrangeira por Saldo")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cambio com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PatchMapping(path = "/{id}/moedaEstrangeiraParaSaldo")
    public ResponseEntity<ContaDTO> moedaEstrangeiraParaSaldo (@RequestParam(value = "id") Long id, @RequestBody OperacoesDTO body){
        return ResponseEntity.ok(this.service.moedaEstrangeiraParaSaldo(id,body));
    }
}
