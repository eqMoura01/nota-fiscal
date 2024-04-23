package com.eqmora.nota.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eqmora.nota.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

} 
