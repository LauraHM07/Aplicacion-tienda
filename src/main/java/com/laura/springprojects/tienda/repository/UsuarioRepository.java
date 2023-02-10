package com.laura.springprojects.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laura.springprojects.tienda.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
    Usuario findByNombre(String username);

}
