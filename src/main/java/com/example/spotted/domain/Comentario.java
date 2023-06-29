package com.example.spotted.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comentario {
    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String texto;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String autor;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resposta> respostas;
}
