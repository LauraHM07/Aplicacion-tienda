package com.laura.springprojects.tienda.services;

import java.util.List;

import com.laura.springprojects.tienda.model.Nota;

public interface NotasService {
    
    public List<Nota> findAll();

    public Nota findByID(int id);

    public Nota insert(Nota nota);

    public void update(Nota nota);

    public void delete(int id);
}
