package com.laura.springprojects.tienda.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.laura.springprojects.tienda.model.Proveedor;

public interface ProveedoresService {

    public Page<Proveedor> findAll(Pageable pageable);

    public Proveedor findById(int codigo);

    public void insert(Proveedor cliente);

    public void update(Proveedor cliente);

    public void delete(int codigo);
}
