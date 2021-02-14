package io.java.curso.springboot;

import io.java.curso.springboot.domain.Cliente;
import io.java.curso.springboot.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired ClienteRepository clienteRepository){
        return args -> {
            Cliente cliente = new Cliente();
            cliente.setNome("Douglas");
            clienteRepository.salvar(cliente);
        };
    }

     public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
