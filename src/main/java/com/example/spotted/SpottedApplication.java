package com.example.spotted;

import com.example.spotted.domain.usuario.Usuario;
import com.example.spotted.domain.usuario.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpottedApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpottedApplication.class, args);
    }

    @Autowired
    private UsuarioRepository repository;

    @PostConstruct
    public void initAlmocos() {

        List<Usuario> users = Stream.of(
                new Usuario(1L, "20220029470", "erick", encoder().encode("1234567")),
                new Usuario(2L, "20210017967", "emerson", encoder().encode("1234567"))

        ).collect(Collectors.toList());

        repository.saveAll(users);
    }

    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}
