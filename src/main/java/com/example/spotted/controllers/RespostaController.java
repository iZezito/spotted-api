package com.example.spotted.controllers;

import com.example.spotted.domain.Resposta;
import com.example.spotted.service.RespostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/respostas")
public class RespostaController extends GenericRestController<Resposta> {

    @Autowired
    private RespostaService respostaService;

    @PostMapping("/{id}")
    public ResponseEntity<Resposta> inserirResposta(@PathVariable Long id, @RequestBody Resposta resposta){
        respostaService.insertResposta(id, resposta);
        return ResponseEntity.ok(resposta);
    }
}
