package com.eqmora.nota.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.RSocket.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eqmora.nota.model.Cliente;
import com.eqmora.nota.repository.ClienteRepository;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(cliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id) {
        Optional<Cliente> cliente = this.clienteRepository.findById(id);

        if (!cliente.isPresent()) {
            throw new EntityNotFoundException("Cliente com o id " + id + " não foi encontrado!");
        }
        return ResponseEntity.ok().body(cliente.get());

    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Cliente>> listAll() {
        return ResponseEntity.ok().body(this.clienteRepository.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.clienteRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
