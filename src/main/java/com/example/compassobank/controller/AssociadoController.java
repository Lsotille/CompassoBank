package com.example.compassobank.controller;

import com.example.compassobank.dto.AssociadoDTO;
import com.example.compassobank.dto.AssociadoFormDTO;
import com.example.compassobank.service.AssociadoService;
import com.example.compassobank.service.AssociadoServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/associado",produces = "application/json")
public class AssociadoController {

    @Autowired
    private AssociadoServiceImpl service;


    @ApiOperation(value = "Cria um Associado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Criado com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping
    public ResponseEntity<AssociadoDTO> salvar(@RequestBody AssociadoFormDTO body) {
        AssociadoDTO state = this.service.salvar(body);
        return ResponseEntity.ok(state);
    }

    @ApiOperation(value = "Procura um Associado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Procurado com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping(path = "/{id}")
    public ResponseEntity<AssociadoDTO> procurar (@PathVariable(value = "id") Long id){
        return ResponseEntity.ok(this.service.procurar(id));
    }

    @ApiOperation(value = "Atualiza um Associado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Atualizado com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PutMapping(path = "/{id}")
    public ResponseEntity<AssociadoDTO> atualizar (@PathVariable(value = "id") Long id, @RequestBody AssociadoFormDTO body){
        return ResponseEntity.ok(this.service.atualizar(id,body));
    }

    @ApiOperation(value = "Remove um Associado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Removido com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<AssociadoDTO> remover (@PathVariable(value = "id") Long id){
        this.service.remover(id);
        return ResponseEntity.ok().build();
    }

}
