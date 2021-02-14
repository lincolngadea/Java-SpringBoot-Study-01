package io.java.curso.springboot;

import io.java.curso.springboot.domain.Cliente;
import io.java.curso.springboot.domain.Pedido;
import io.java.curso.springboot.repository.ClienteRepository;
import io.java.curso.springboot.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(
            @Autowired ClienteRepository clienteRepository,
            @Autowired PedidoRepository pedidoRepository) {
        return args -> {
            System.out.println("SALVANDO CLIENTES");

            Cliente clienteVip = new Cliente("Rafael");
            clienteRepository.save(clienteVip);

            Pedido p = new Pedido();
            p.setCliente(clienteVip);
            p.setDataPedido(LocalDate.now());
            p.setTotal(BigDecimal.valueOf(100));
            pedidoRepository.save(p);

            Cliente cliente = clienteRepository.findClienteFetchPedidos(clienteVip.getId());
            System.out.println(cliente);
            System.out.println(cliente.getPedidos());
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
