package com.laura.springprojects.tienda.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laura.springprojects.tienda.model.Producto;
import com.laura.springprojects.tienda.repository.ProductoRepository;
import com.laura.springprojects.tienda.services.ProductosService;

@Service
public class ProductosServiceImpl implements ProductosService {
    
    @Autowired
    ProductoRepository repository;
    
    @Override
    public Page<Producto> findAll(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Producto findById(int codigo) {
        Optional<Producto> findById = repository.findById(codigo);

        if(findById != null) {
            return findById.get();
        }

        return null;
    }

    @Override
    public void insert(Producto producto){
        repository.save(producto);
    }

    @Override
    public void update(Producto producto) {
        repository.save(producto);
    }

    @Override
    public void delete(int codigo){
        repository.deleteById(codigo);
    }
}
