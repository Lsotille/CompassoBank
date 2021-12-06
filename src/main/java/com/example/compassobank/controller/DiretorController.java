package com.example.compassobank.controller;


import com.example.compassobank.dto.*;
import com.example.compassobank.service.DiretorService;
import com.example.compassobank.service.DiretorServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/diretor",produces = "application/json")
public class DiretorController {

    @Autowired
    private DiretorServiceImpl service;

    @ApiOperation(value = "Cria um Gerente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Criado com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping
    public ResponseEntity<DiretorDTO> salvar(@RequestBody DiretorFormDTO body) {
        DiretorDTO state = this.service.salvar(body);
        return ResponseEntity.ok(state);
    }

    @ApiOperation(value = "Procura um Gerente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Procurado com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping(path = "/{id}")
    public ResponseEntity<DiretorDTO> procurar (@RequestParam(value = "id") Long id){
        return ResponseEntity.ok(this.service.procurar(id));
    }

    @ApiOperation(value = "Atualiza um Gerente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Atualiza com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PutMapping(path = "/{id}")
    public ResponseEntity<DiretorDTO> atualizar (@RequestParam(value = "id") Long id, @RequestBody DiretorFormDTO body){
        return ResponseEntity.ok(this.service.atualizar(id,body));
    }

    @ApiOperation(value = "Remove um Gerente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Removido com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<DiretorDTO> remover (@RequestParam(value = "id") Long id){
        this.service.remover(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(path = "/{id}/mudarSalario")
    public ResponseEntity<BanqueiroDTO> mudarSalario(@RequestParam(value = "id")Long id, @RequestBody OperacoesDTO body){
        return ResponseEntity.ok(this.service.mudarSalario(id,body));
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

    @ApiOperation(value = "Abonar Divida Pessoal")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Abonada com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping(path = "/{id}/abonarDividaPessoal")
    public ResponseEntity<ContaPessoalDTO> abonarDividaPessoal(@RequestParam(value = "id")Long id){
        ContaPessoalDTO state = this.service.abonarDividaPessoal(id);
        return ResponseEntity.ok(state);
    }

    @ApiOperation(value = "Abonar Divida Empresarial")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Abonada com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping(path = "/{id}/abonarDividaEmpresarial")
    public ResponseEntity<ContaEmpresarialDTO> abonarDividaEmpresarial (@RequestParam(value = "id")Long id){
        ContaEmpresarialDTO state = this.service.abonarDividaEmpresarial(id);
        return ResponseEntity.ok(state);
    }

    @ApiOperation(value = "Promover Banqueiro")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Promovido com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping(path = "/{id}/promoverBanqueiro")
    public ResponseEntity<BanqueiroDTO> promoverBanqueiro(@RequestParam(value = "id")Long id){
        BanqueiroDTO state = this.service.promoverBanqueiro(id);
        return ResponseEntity.ok(state);
    }

    @ApiOperation(value = "Promover Gerente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Promovido com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping(path = "/{id}/promoverGernte")
    public ResponseEntity<GerenteDTO> promoverGerente(@RequestParam(value = "id")Long id){
        GerenteDTO state = this.service.promoverGerente(id);
        return ResponseEntity.ok(state);
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
