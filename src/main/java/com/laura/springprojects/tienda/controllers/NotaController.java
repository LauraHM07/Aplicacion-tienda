package com.laura.springprojects.tienda.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.laura.springprojects.tienda.model.Nota;
import com.laura.springprojects.tienda.services.NotasService;

@Controller
@RequestMapping("/notas")
public class NotaController {
    
    @Autowired
    NotasService notasService;

    @GetMapping(value = "/list")
    public ModelAndView listPage(Model model) {

        List<Nota> notas = notasService.findAll();

        ModelAndView modelAndView = new ModelAndView("notas/list");
        modelAndView.addObject("notas", notas);

        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView create(Nota nota) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("nota", new Nota());
        modelAndView.setViewName("notas/new");

        return modelAndView;
    }

    @PostMapping(path = "/save")
    public ModelAndView save(Nota nota) throws IOException {

        Nota nota2 = notasService.insert(nota);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + nota2.getId());

        return modelAndView;
    }

    @GetMapping(path = { "/edit/{id}" })
    public ModelAndView edit(
            @PathVariable(name = "id", required = true) int id) {

        Nota nota = notasService.findByID(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("nota", nota);
        modelAndView.setViewName("notas/edit");
        return modelAndView;
    }

    @PostMapping(path = { "/update" })
    public ModelAndView update(Nota nota) {

        notasService.update(nota);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + nota.getId());

        return modelAndView;
    }

    @GetMapping(path = { "/delete/{id}" })
    public ModelAndView delete(
            @PathVariable(name = "id", required = true) int id) {

        notasService.delete(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/notas/list");

        return modelAndView;
    }
}
