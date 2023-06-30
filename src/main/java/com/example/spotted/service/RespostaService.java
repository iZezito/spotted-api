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

    public void updateResposta(Long id, String texto) {
        Resposta respostaAtual = getById(id);
        respostaAtual.setTexto(texto);
        update(respostaAtual);
    }

    public void delete(Long id, Long idComentario) {
        Comentario comentario = comentarioService.getById(idComentario);
        Resposta resposta = getById(id);
        comentario.getRespostas().remove(resposta);
        comentarioService.update(comentario);
        super.delete(resposta);
    }
}
