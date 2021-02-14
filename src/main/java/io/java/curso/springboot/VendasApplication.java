package io.java.curso.springboot;

import io.java.curso.springboot.domain.Cliente;
import io.java.curso.springboot.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired ClienteRepository clienteRepository) {
        return args -> {
            System.out.println("SALVANDO CLIENTES");
            clienteRepository.save(new Cliente("Doublas"));
            clienteRepository.save(new Cliente("Lincoln"));

            List<Cliente> clienteList= clienteRepository.encontrarPorNome("Lincoln");

            clienteList.forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
