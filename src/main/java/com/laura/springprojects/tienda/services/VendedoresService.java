package com.laura.springprojects.tienda.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.laura.springprojects.tienda.model.Vendedor;

public interface VendedoresService {
    
    public Page<Vendedor> findAll(Pageable pageable);

    public Vendedor findById(int codigo);

    public void insert(Vendedor cliente);

    public void update(Vendedor cliente);

    public void delete(int codigo);
}
