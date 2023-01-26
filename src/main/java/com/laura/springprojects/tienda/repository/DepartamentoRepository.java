package com.laura.springprojects.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laura.springprojects.tienda.model.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer>{
    
}
