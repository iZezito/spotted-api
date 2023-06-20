package com.example.spotted.service;

import com.example.spotted.domain.Comentario;
import com.example.spotted.domain.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RespostaService extends GenericService<Resposta>{

    @Autowired
    private ComentarioService comentarioService;
    public void insertResposta(Long idComentario, Resposta resposta){
        Comentario comentario = comentarioService.getById(idComentario);
        comentario.getRespostas().add(resposta);
        comentarioService.update(comentario);
    }
}
