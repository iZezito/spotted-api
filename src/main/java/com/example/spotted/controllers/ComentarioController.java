package com.example.spotted.controllers;

import com.example.spotted.domain.Comentario;
import com.example.spotted.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController extends GenericRestController<Comentario> {
    @Autowired
    private ComentarioService comentarioService;

    @PostMapping("/{id}")
    public void inserirComment(@PathVariable Long id, @RequestBody Comentario comentario){
        comentarioService.insertComentario(id, comentario);
    }

}
