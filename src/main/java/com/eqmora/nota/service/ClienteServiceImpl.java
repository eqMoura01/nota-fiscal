package com.eqmora.nota.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eqmora.nota.model.Cliente;
import com.eqmora.nota.repository.ClienteRepository;
import com.eqmora.nota.service.interfaces.ClienteService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente save(Cliente object) {
        return this.clienteRepository.save(object);
    }

    @Override
    public List<Cliente> list() {
        return this.clienteRepository.findAll();
    }

    @Override
    public Cliente searchById(Long id) {
        
        Optional<Cliente> cliente = this.clienteRepository.findById(id);

        if (!cliente.isPresent()) {
            throw new EntityNotFoundException(String.format("O cliente com o id %s não pode ser encontrado.", id));
        }
        
        return cliente.get();
    }

    @Override
    public Cliente update(Cliente object) {
        Cliente cliente = this.searchById(object.getId());

        if (Objects.nonNull(cliente)) {
            BeanUtils.copyProperties(object, cliente, "id");
            
            this.save(object);
        }

        return object;
    }

    @Override
    public void deleteById(Long id) {
        this.searchById(id);

        this.clienteRepository.deleteById(id);
    }
    
}
