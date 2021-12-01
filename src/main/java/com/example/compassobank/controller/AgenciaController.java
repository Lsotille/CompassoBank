package com.example.compassobank.controller;
import com.example.compassobank.dto.AgenciaDTO;
import com.example.compassobank.dto.AgenciaFormDTO;
import com.example.compassobank.service.AgenciaService;
import com.example.compassobank.service.AgenciaServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/agencia",produces= "application/json")
public class AgenciaController {

    @Autowired
    private AgenciaServiceImpl service;


    @ApiOperation(value = "Cria uma Agencia")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Criado com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping
    public ResponseEntity<AgenciaDTO> salvar(@RequestBody AgenciaFormDTO body) {
        AgenciaDTO state = this.service.salvar(body);
        return ResponseEntity.ok(state);
    }

    @ApiOperation(value = "Procura uma Agencia")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Procurado com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping(path = "/{id}")
    public ResponseEntity<AgenciaDTO> procurar (@RequestParam(value = "id") Long id){
        return ResponseEntity.ok(this.service.procurar(id));
    }

    @ApiOperation(value = "Atualiza uma Agencia")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Atualizado com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PutMapping(path = "/{id}")
    public ResponseEntity<AgenciaDTO> atualizar (@RequestParam(value = "id") Long id, @RequestBody AgenciaFormDTO body){
        return ResponseEntity.ok(this.service.atualizar(id,body));
    }

    @ApiOperation(value = "Remove uma Agencia")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Removido com Sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<AgenciaDTO> remover (@RequestParam(value = "id") Long id){
        this.service.remover(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/{id}/divisaoLucros")
    public ResponseEntity<BigDecimal> divisaoLucros (@RequestParam(value = "id") Long id){
        return ResponseEntity.ok(this.service.divisaoLucros(id));
    }

}
