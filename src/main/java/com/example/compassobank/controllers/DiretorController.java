package com.example.compassobank.controllers;


import com.example.compassobank.dto.*;
import com.example.compassobank.services.BanqueiroService;
import com.example.compassobank.services.DiretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/direto")
public class DiretorController {

    @Autowired
    private DiretorService service;

    @PostMapping
    public ResponseEntity<DiretorDTO> salvar(@RequestBody DiretorFormDTO body) {
        DiretorDTO state = this.service.salvar(body);
        return ResponseEntity.ok(state);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DiretorDTO> procurar (@RequestParam(value = "id") Long id){
        return ResponseEntity.ok(this.service.procurar(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<DiretorDTO> atualizar (@RequestParam(value = "id") Long id, @RequestBody DiretorFormDTO body){
        return ResponseEntity.ok(this.service.atualizar(id,body));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<DiretorDTO> remover (@RequestParam(value = "id") Long id){
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

    @PostMapping(path = "/{id}/abonarDividaPessoal")
    public ResponseEntity<ContaPessoalDTO> abonarDividaPessoal(@RequestParam(value = "id")Long id){
        ContaPessoalDTO state = this.service.abonarDividaPessoal(id);
        return ResponseEntity.ok(state);
    }
    @PostMapping(path = "/{id}/abonarDividaEmpresarial")
    public ResponseEntity<ContaEmpresarialDTO> abonarDividaEmpresarial (@RequestParam(value = "id")Long id){
        ContaEmpresarialDTO state = this.service.abonarDividaEmpresarial(id);
        return ResponseEntity.ok(state);
    }
    @PostMapping(path = "/{id}/promoverBanqueiro")
    public ResponseEntity<BanqueiroDTO> promoverBanqueiro(@RequestParam(value = "id")Long id){
        BanqueiroDTO state = this.service.promoverBanqueiro(id);
        return ResponseEntity.ok(state);
    }

    @PostMapping(path = "/{id}/promoverGernte")
    public ResponseEntity<GerenteDTO> promoverGerente(@RequestParam(value = "id")Long id){
        GerenteDTO state = this.service.promoverGerente(id);
        return ResponseEntity.ok(state);
    }

}
