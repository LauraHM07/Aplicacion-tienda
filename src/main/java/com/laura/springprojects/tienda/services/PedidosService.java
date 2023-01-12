package com.laura.springprojects.tienda.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.laura.springprojects.tienda.model.Pedido;

public interface PedidosService {
    public Page<Pedido> findAll(Pageable page);

    public Pedido find(int codigo);

    public void save(Pedido pedido);

    public void delete(int codigo);
}
