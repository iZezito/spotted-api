package com.example.spotted.service;

import com.example.spotted.domain.Comentario;
import com.example.spotted.domain.Noticia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService extends GenericService<Comentario>{
    @Autowired
    private NoticiaService noticiaService;


    public void insertComentario(Long idNoticia, Comentario comentario){
        Noticia noticia = noticiaService.getById(idNoticia);
        noticia.getComentarios().add(comentario);
        noticiaService.update(noticia);
    }

    public void updateComentario(Long id, String comentario) {
        Comentario comentarioAtual = getById(id);
        comentarioAtual.setTexto(comentario);
        update(comentarioAtual);
    }
}
