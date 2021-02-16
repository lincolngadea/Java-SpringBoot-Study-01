package io.java.curso.springboot.domain.repository;

import io.java.curso.springboot.domain.entity.Cliente;
import io.java.curso.springboot.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByCliente(Cliente cliente);
}
