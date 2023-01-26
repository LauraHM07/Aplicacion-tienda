package com.laura.springprojects.tienda.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.laura.springprojects.tienda.model.Empleado;

public interface EmpleadosService {

    public Page<Empleado> findAll(Pageable pageable);

    public Empleado findById(int codigo);

    public void insert(Empleado cliente);

    public void update(Empleado cliente);

    public void delete(int codigo);
}
