package com.laura.springprojects.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laura.springprojects.tienda.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
}
