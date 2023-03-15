package com.example.spotted.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Noticia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String titulo;
    @NotBlank
    //column without size limit
    @Column(columnDefinition = "TEXT")
    private String descricao;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios;

}
