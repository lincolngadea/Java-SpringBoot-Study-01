package io.java.curso.springboot.repository;

import io.java.curso.springboot.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findBynomeLike(String nome);
    boolean existsByNome(String nome);
}
