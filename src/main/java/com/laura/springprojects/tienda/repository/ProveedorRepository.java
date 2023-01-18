package com.laura.springprojects.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laura.springprojects.tienda.model.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
    
}
