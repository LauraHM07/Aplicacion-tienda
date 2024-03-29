package com.laura.springprojects.tienda.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laura.springprojects.tienda.model.Cliente;
import com.laura.springprojects.tienda.repository.ClienteRepository;
import com.laura.springprojects.tienda.services.ClientesService;

@Service
public class ClientesServiceImpl implements ClientesService {

    @Autowired
    ClienteRepository repository;

    @Override
    public Page<Cliente> findAll(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Cliente findById(int codigo) {
        Optional<Cliente> findById = repository.findById(codigo);

        if(findById != null) {
            return findById.get();
        }

        return null;
    }

    @Override
    public void insert(Cliente cliente){
        repository.save(cliente);
    }

    @Override
    public void update(Cliente cliente) {
        repository.save(cliente);
    }

    @Override
    public void delete(int codigo){
        repository.deleteById(codigo);
    }
}
