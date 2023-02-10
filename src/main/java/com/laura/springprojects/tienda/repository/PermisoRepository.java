package com.laura.springprojects.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laura.springprojects.tienda.model.Permiso;

public interface PermisoRepository extends JpaRepository<Permiso, Integer>{
    
}
