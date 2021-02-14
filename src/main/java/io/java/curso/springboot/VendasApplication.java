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
    public CommandLineRunner init(@Autowired ClienteRepository clienteRepository){
        return args -> {
           clienteRepository.salvar(new Cliente("Doublas"));
           clienteRepository.salvar(new Cliente("Lincoln"));

           List<Cliente> listaDeClientes = clienteRepository.listarClientes();
           listaDeClientes.forEach(System.out::println);
        };
    }

     public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
