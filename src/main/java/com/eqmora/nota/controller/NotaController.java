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

import com.eqmora.nota.model.Nota;
import com.eqmora.nota.service.interfaces.NotaService;

@RestController
@RequestMapping("/nota")
public class NotaController {
    
    @Autowired
    private NotaService notaService;

    @PostMapping
    public ResponseEntity<Nota> save(@RequestBody Nota object){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.notaService.save(object));
    }

    @GetMapping("listAll")
    public ResponseEntity<List<Nota>> listAll(){
        return ResponseEntity.ok().body(this.notaService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nota> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(this.notaService.searchById(id));
    }

    @PutMapping
    public ResponseEntity<Nota> update(@RequestBody Nota object){
        return ResponseEntity.ok().body(this.notaService.update(object));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        this.notaService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
