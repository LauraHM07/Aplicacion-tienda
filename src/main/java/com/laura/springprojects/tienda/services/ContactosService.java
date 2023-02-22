package com.laura.springprojects.tienda.services;

import java.util.List;

import com.laura.springprojects.tienda.model.Contacto;

public interface ContactosService {
    
    public List<Contacto> findAll();

    public Contacto findByID(int id);

    public Contacto insert(Contacto contacto);

    public void update(Contacto contacto);

    public void delete(int id);
}
