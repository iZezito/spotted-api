package com.example.spotted.controllers;

import com.example.spotted.domain.Comentario;
import com.example.spotted.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController extends GenericRestController<Comentario> {
    @Autowired
    private ComentarioService comentarioService;

    @PostMapping("/{id}")
    public ResponseEntity<Comentario> inserirComment(@PathVariable Long id, @RequestBody Comentario comentario){
        Comentario comentarioInserido = comentarioService.insertComentario(id, comentario);
        return ResponseEntity.ok(comentarioInserido);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateComment(@PathVariable Long id, @RequestBody Comentario comentario){
        System.out.println("Entrou no patch");
        System.out.println(comentario);
        comentarioService.updateComentario(id, comentario.getTexto());
        return ResponseEntity.ok(comentario.getTexto());
    }

    @DeleteMapping("/{id}/{idNoticia}")
    public ResponseEntity<?> deleteComment(@PathVariable Long id, @PathVariable Long idNoticia) {
        Comentario comentario = comentarioService.getById(id);
        if (comentario == null) {
            return ResponseEntity.notFound().build();
        }
        comentarioService.delete(id, idNoticia);
        return ResponseEntity.ok().build();
    }

}
