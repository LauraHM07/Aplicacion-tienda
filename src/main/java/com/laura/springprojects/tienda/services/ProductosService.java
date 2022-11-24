package com.laura.springprojects.tienda.services;
import java.util.List;

import com.laura.springprojects.tienda.model.Producto;

public interface ProductosService {
    
    public List<Producto> findAll();

    public Producto findById(int codigo);

    public void insert(Producto producto);

    public void update(Producto producto);

    public void delete(int codigo);
}
