package com.laura.springprojects.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laura.springprojects.tienda.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
    
}
