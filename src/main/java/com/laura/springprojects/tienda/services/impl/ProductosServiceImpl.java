package com.laura.springprojects.tienda.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laura.springprojects.tienda.dao.ProductosDAO;
import com.laura.springprojects.tienda.model.Producto;
import com.laura.springprojects.tienda.services.ProductosService;

@Service
public class ProductosServiceImpl implements ProductosService {
    
    @Autowired
    ProductosDAO productosDAO;

    @Override
    public List<Producto> findAll() {
        return productosDAO.findAll();
    }

    @Override
    public Producto findById(int codigo) {
        return productosDAO.findById(codigo);
    }

    @Override
    public void insert(Producto producto){
        productosDAO.insert(producto);
    }

    @Override
    public void update(Producto producto) {
        productosDAO.update(producto);
    }

    @Override
    public void delete(int codigo){
        productosDAO.delete(codigo);
    }
}
