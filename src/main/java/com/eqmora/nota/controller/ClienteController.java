package com.eqmora.nota.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eqmora.nota.model.Cliente;
import com.eqmora.nota.service.interfaces.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody Cliente object) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.clienteService.save(object));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.clienteService.searchById(id));
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Cliente>> listAll() {
        return ResponseEntity.ok().body(this.clienteService.list());
    }

    @PutMapping
    public ResponseEntity<Cliente> update(@RequestBody Cliente object){
        return ResponseEntity.ok().body(this.clienteService.update(object));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.clienteService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
