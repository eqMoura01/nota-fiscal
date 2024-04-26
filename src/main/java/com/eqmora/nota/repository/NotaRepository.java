package com.eqmora.nota.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eqmora.nota.model.Nota;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long>{
    
}
