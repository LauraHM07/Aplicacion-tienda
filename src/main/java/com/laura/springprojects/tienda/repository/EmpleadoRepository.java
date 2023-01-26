package com.laura.springprojects.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laura.springprojects.tienda.model.Empleado;

public interface  EmpleadoRepository extends JpaRepository<Empleado, Integer>{
    
}
