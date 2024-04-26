package com.eqmora.nota.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eqmora.nota.model.Cliente;
import com.eqmora.nota.model.Nota;
import com.eqmora.nota.repository.NotaRepository;
import com.eqmora.nota.service.interfaces.NotaService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class NotaServiceImpl implements NotaService{

    @Autowired
    private NotaRepository notaRepository;

    @Override
    public Nota save(Nota object) {
        return this.notaRepository.save(object);
    }

    @Override
    public List<Nota> list() {
        return this.notaRepository.findAll();
    }

    @Override
    public Nota searchById(Long id) {
        Optional<Nota> object = this.notaRepository.findById(id);

        if (!object.isPresent()) {
            throw new EntityNotFoundException(String.format("A nota com o id %s não pode ser encontrada.", id));
        }
        
        return object.get();
    }

    @Override
    public Nota update(Nota object) {
        Nota nota = this.searchById(object.getId());

        if (Objects.nonNull(nota)) {
            BeanUtils.copyProperties(object, nota, "id");
            
            this.save(object);
        }

        return object;
    }

    @Override
    public void deleteById(Long id) {
        this.searchById(id);

        this.deleteById(id);
    }
    
}
