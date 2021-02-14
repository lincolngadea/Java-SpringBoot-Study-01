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

            List<Cliente> listaDeClientes = clienteRepository.findAll();
            listaDeClientes.forEach(System.out::println);

            System.out.println("ATUALIZANDO CLIENTES");
            listaDeClientes.forEach((cliente -> {
                cliente.setNome(cliente.getNome()+" atualizado.");
                clienteRepository.save(cliente);
            }));
            
            listaDeClientes = clienteRepository.findAll();
            listaDeClientes.forEach(System.out::println);

            System.out.println("BUSCANDO CLIENTES POR NOME");
            clienteRepository.findBynomeLike("Lin").forEach(System.out::println);

            System.out.println("DELETANDO TODOS OS CLIENTES");
            clienteRepository.findAll().forEach(cliente -> {
                clienteRepository.delete(cliente);
            });

            listaDeClientes = clienteRepository.findAll();
            if(listaDeClientes.isEmpty()){
                System.out.println("NENHUM CLIENTE ENCONTRADO NA BASE DE DADOS");
            }else{
                listaDeClientes.forEach(System.out::println);
            }

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
