package io.java.curso.springboot.service;

import io.java.curso.springboot.model.Cliente;
import io.java.curso.springboot.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    public void salvarCliente(Cliente cliente){
        validarCliente(cliente);
        this.clienteRepository.persistir(cliente);
    }

    public void validarCliente(Cliente cliente){
    }

}
