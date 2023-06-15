package com.example.spotted.controllers;

import com.example.spotted.domain.Noticia;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/noticias")
public class NoticiaController extends GenericRestController<Noticia> {

}
