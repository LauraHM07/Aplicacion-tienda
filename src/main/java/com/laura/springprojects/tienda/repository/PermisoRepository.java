package com.laura.springprojects.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laura.springprojects.tienda.model.Permiso;

@Repository
public interface PermisoRepository extends JpaRepository<Permiso, Long>{
    
}
