package com.laura.springprojects.tienda.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laura.springprojects.tienda.model.Proveedor;
import com.laura.springprojects.tienda.repository.ProveedorRepository;
import com.laura.springprojects.tienda.services.ProveedoresService;

@Service
public class ProveedoresServiceImpl implements ProveedoresService{
    
    @Autowired
    ProveedorRepository repository;

    @Override
    public Page<Proveedor> findAll(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Proveedor findById(int codigo) {
        Optional<Proveedor> findById = repository.findById(codigo);

        if(findById != null) {
            return findById.get();
        }

        return null;
    }

    @Override
    public void insert(Proveedor proveedor){
        repository.save(proveedor);
    }

    @Override
    public void update(Proveedor proveedor) {
        repository.save(proveedor);
    }

    @Override
    public void delete(int codigo){
        repository.deleteById(codigo);
    }
}
