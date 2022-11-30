package com.laura.springprojects.tienda.dao;
import java.util.List;

import com.laura.springprojects.tienda.model.Producto;

public interface ProductosDAO {
    public List<Producto> findAll();

    public Producto findById(int codigo);

    public void insert(Producto producto);

    public void update(Producto producto);

    public void updateImage(Producto producto);

    public void delete(int codigo);
}
