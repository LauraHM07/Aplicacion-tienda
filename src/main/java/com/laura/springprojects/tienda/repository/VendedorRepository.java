package com.laura.springprojects.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laura.springprojects.tienda.model.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer>{
    
}
