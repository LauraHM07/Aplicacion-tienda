package com.laura.springprojects.tienda.services.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.laura.springprojects.tienda.model.Nota;
import com.laura.springprojects.tienda.services.NotasService;

@Service
public class NotasServiceImpl implements NotasService {

    @Value("${url.notas.rest.service}")
    String urlNota;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<Nota> findAll() {
        
        Nota[] nota2 = restTemplate.getForObject(urlNota + "notas", Nota[].class);
        List<Nota> notas = Arrays.asList(nota2);

        return notas;
    }

    @Override
    public Nota findByID(int id) {
        Nota nota2 = restTemplate.getForObject(urlNota + "notas/" + id, Nota.class);

        return nota2;
    }

    @Override
    public Nota insert(Nota nota) {
        Nota nota2 = restTemplate.postForObject(urlNota + "notas", nota, Nota.class);

        return nota2;
    }

    @Override
    public void update(Nota nota) {
        restTemplate.put(urlNota + "notas/" + nota.getId(), nota);
    }

    @Override
    public void delete(int id) {
        restTemplate.delete(urlNota + "notas/" + id);
        
    }
}
