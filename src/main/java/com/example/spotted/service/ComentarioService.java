package com.example.spotted.service;

import com.example.spotted.domain.Comentario;
import com.example.spotted.domain.Noticia;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService extends GenericService<Comentario>{
    @Autowired
    private NoticiaService noticiaService;


    public Comentario insertComentario(Long idNoticia, Comentario comentario){
        Noticia noticia = noticiaService.getById(idNoticia);
        noticia.getComentarios().add(comentario);
        noticiaService.update(noticia);
        return noticiaService.getById(idNoticia).getComentarios().get(noticia.getComentarios().size()-1);
    }

    public void updateComentario(Long id, String comentario) {
        Comentario comentarioAtual = getById(id);
        comentarioAtual.setTexto(comentario);
        update(comentarioAtual);
    }


    public void delete(Long id, Long idNoticia) {
        Noticia noticia = noticiaService.getById(idNoticia);
        Comentario comentario = getById(id);
        noticia.getComentarios().remove(comentario);
        noticiaService.update(noticia);
        super.delete(comentario);
    }

    public List<Comentario> getComentarios(Long idNoticia) {
        Noticia noticia = noticiaService.getById(idNoticia);
        return noticia.getComentarios();
    }
}
