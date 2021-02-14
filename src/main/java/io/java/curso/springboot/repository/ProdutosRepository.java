package io.java.curso.springboot.repository;

import io.java.curso.springboot.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends JpaRepository<Produto, Integer> {
}
