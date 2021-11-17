package com.example.compassobank.controllers;
import com.example.compassobank.dto.AgenciaDTO;
import com.example.compassobank.dto.AgenciaFormDTO;
import com.example.compassobank.dto.AgenciaDTO;
import com.example.compassobank.dto.AssociadoFormDTO;
import com.example.compassobank.services.AgenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agencia")
public class AgenciaController {

    @Autowired
    private AgenciaService service;

    @PostMapping
    public ResponseEntity<AgenciaDTO> salvar(@RequestBody AgenciaFormDTO body) {
        AgenciaDTO state = this.service.salvar(body);
        return ResponseEntity.ok(state);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AgenciaDTO> procurar (@RequestParam(value = "id") Long id){
        return ResponseEntity.ok(this.service.procurar(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<AgenciaDTO> atualizar (@RequestParam(value = "id") Long id, @RequestBody AgenciaFormDTO body){
        return ResponseEntity.ok(this.service.atualizar(id,body));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<AgenciaDTO> remover (@RequestParam(value = "id") Long id){
        this.service.remover(id);
        return ResponseEntity.ok().build();
    }

}
