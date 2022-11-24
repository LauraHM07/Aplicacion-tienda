package com.laura.springprojects.tienda.services;
import java.util.List;

import com.laura.springprojects.tienda.model.Cliente;

public interface ClientesService {
    
    public List<Cliente> findAll();

    public Cliente findById(int codigo);

    public void insert(Cliente cliente);

    public void update(Cliente cliente);

    public void delete(int codigo);
}
