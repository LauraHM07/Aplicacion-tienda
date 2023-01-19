package com.laura.springprojects.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laura.springprojects.tienda.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{
    
}
