package com.globalsolution.upskilling.config;

import com.globalsolution.upskilling.model.Trilha;
import com.globalsolution.upskilling.model.Usuario;
import com.globalsolution.upskilling.repository.TrilhaRepository;
import com.globalsolution.upskilling.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class DataSeeder implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final TrilhaRepository trilhaRepository;

    public DataSeeder(UsuarioRepository usuarioRepository, TrilhaRepository trilhaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.trilhaRepository = trilhaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Aguarda o Hibernate terminar de criar as tabelas
        Thread.sleep(2000);

        if (usuarioRepository.count() == 0 && trilhaRepository.count() == 0) {
            usuarioRepository.save(new Usuario("Carlos Eduardo", "carlos@example.com", "Engenharia de Software", "Junior"));
            usuarioRepository.save(new Usuario("Ana Pereira", "ana.pereira@example.com", "Dados", "Em transição"));

            trilhaRepository.save(new Trilha("Introdução à IA", "Conceitos fundamentais de IA, ML e aplicações", "INICIANTE", 40, "IA"));
            trilhaRepository.save(new Trilha("Análise de Dados", "Ferramentas e práticas para análise de dados", "INTERMEDIARIO", 60, "Dados"));
            trilhaRepository.save(new Trilha("Soft Skills para o futuro", "Colaboração, comunicação e empatia", "INICIANTE", 20, "Soft Skills"));
        }
    }
}

