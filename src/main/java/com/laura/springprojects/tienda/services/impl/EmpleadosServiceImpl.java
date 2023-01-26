package com.laura.springprojects.tienda.services.impl;

import com.laura.springprojects.tienda.model.Empleado;
import com.laura.springprojects.tienda.repository.EmpleadoRepository;
import com.laura.springprojects.tienda.services.EmpleadosService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmpleadosServiceImpl implements EmpleadosService{

    @Autowired
    EmpleadoRepository repository;

    @Override
    public Page<Empleado> findAll(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Empleado findById(int codigo) {
        Optional<Empleado> findById = repository.findById(codigo);

        if(findById != null) {
            return findById.get();
        }

        return null;
    }

    @Override
    public void insert(Empleado empleado){
        repository.save(empleado);
    }

    @Override
    public void update(Empleado empleado) {
        repository.save(empleado);
    }

    @Override
    public void delete(int codigo){
        repository.deleteById(codigo);
    }
}
