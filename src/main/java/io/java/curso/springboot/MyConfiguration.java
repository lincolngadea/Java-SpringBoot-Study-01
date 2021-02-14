package io.java.curso.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Development
public class MyConfiguration {

    @Bean
   public CommandLineRunner executar(){
        return args -> {
            System.out.println("RODANDO NO AMBIENTE DE DESENVOLVIMENTO!");
        };
    }
}
