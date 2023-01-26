package com.laura.springprojects.tienda.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.laura.springprojects.tienda.model.Departamento;

public interface DepartamentosService {
    
    public Page<Departamento> findAll(Pageable pageable);

    public Departamento findById(int codigo);

    public void insert(Departamento departamento);

    public void update(Departamento departamento);

    public void delete(int codigo);
}
