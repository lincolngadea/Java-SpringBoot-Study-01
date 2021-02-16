package io.java.curso.springboot.rest.controller;

import io.java.curso.springboot.domain.entity.Cliente;
import io.java.curso.springboot.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/api/clientes/{id}")
    @ResponseBody
    public ResponseEntity getClienteById(@PathVariable Integer id){
        Optional<Cliente> clienteRepositoryById = clienteRepository.findById(id);
        if(clienteRepositoryById.isPresent()){
            return ResponseEntity.ok(clienteRepositoryById.get());
        }
        return ResponseEntity.notFound().build();
    }
}
