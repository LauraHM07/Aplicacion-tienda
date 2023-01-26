package com.laura.springprojects.tienda.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laura.springprojects.tienda.model.Departamento;
import com.laura.springprojects.tienda.repository.DepartamentoRepository;
import com.laura.springprojects.tienda.services.DepartamentosService;

@Service
public class DepartamentosServiceImpl implements DepartamentosService{
    
    @Autowired
    DepartamentoRepository repository;

    @Override
    public Page<Departamento> findAll(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Departamento findById(int codigo) {
        Optional<Departamento> findById = repository.findById(codigo);

        if(findById != null) {
            return findById.get();
        }

        return null;
    }

    @Override
    public void insert(Departamento departamento){
        repository.save(departamento);
    }

    @Override
    public void update(Departamento departamento) {
        repository.save(departamento);
    }

    @Override
    public void delete(int codigo){
        repository.deleteById(codigo);
    }
}
