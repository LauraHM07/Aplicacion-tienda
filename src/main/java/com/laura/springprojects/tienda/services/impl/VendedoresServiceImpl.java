package com.laura.springprojects.tienda.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laura.springprojects.tienda.model.Vendedor;
import com.laura.springprojects.tienda.repository.VendedorRepository;
import com.laura.springprojects.tienda.services.VendedoresService;

@Service
public class VendedoresServiceImpl implements VendedoresService{
    
    @Autowired
    VendedorRepository repository;

    @Override
    public Page<Vendedor> findAll(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Vendedor findById(int codigo) {
        Optional<Vendedor> findById = repository.findById(codigo);

        if(findById != null) {
            return findById.get();
        }

        return null;
    }

    @Override
    public void insert(Vendedor vendedor){
        repository.save(vendedor);
    }

    @Override
    public void update(Vendedor vendedor) {
        repository.save(vendedor);
    }

    @Override
    public void delete(int codigo){
        repository.deleteById(codigo);
    }
}
