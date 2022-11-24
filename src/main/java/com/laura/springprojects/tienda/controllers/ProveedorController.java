package com.laura.springprojects.tienda.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.laura.springprojects.tienda.model.Proveedor;

@Controller
@RequestMapping("/proveedores")
public class ProveedorController {

    @GetMapping(value = "/list")
    public ModelAndView list(Model model) {

        ModelAndView modelAndView = new ModelAndView("proveedores/list");
        modelAndView.addObject("proveedores", getProveedores());
        modelAndView.addObject("title", "proveedores");
        return modelAndView;
    }

    @GetMapping(path = { "/edit/{codigo}" })
    public ModelAndView edit(
            @PathVariable(name = "codigo", required = true) int codigo) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("proveedor", getProveedor(codigo));
        modelAndView.setViewName("proveedores/edit");
        return modelAndView;
    }

    @GetMapping(path = { "/create" })
    public ModelAndView create(Proveedor proveedor) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("proveedor", new Proveedor());
        modelAndView.setViewName("proveedores/new");
        return modelAndView;
    }

    @PostMapping(path = { "/save" })
    public ModelAndView save(Proveedor proveedor) {

        int round = (int) (Math.random() * (100 + 5));

        proveedor.setCodigo(round);

        List<Proveedor> proveedores = getProveedores();
        proveedores.add(proveedor);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("proveedores", proveedores);
        modelAndView.setViewName("proveedores/list");
        return modelAndView;
    }

    @PostMapping(path = { "/update" })
    public ModelAndView update(Proveedor proveedor) {

        List<Proveedor> proveedores = getProveedores();

        int indexOf = proveedores.indexOf(proveedor);

        proveedores.set(indexOf, proveedor);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("proveedores", proveedores);
        modelAndView.setViewName("proveedores/list");
        return modelAndView;
    }

    @GetMapping(path = { "/delete/{codigo}" })
    public ModelAndView delete(
            @PathVariable(name = "codigo", required = true) int codigo) {

        List<Proveedor> proveedores = getProveedores();
        proveedores.remove(getProveedor(codigo));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("proveedores", proveedores);
        modelAndView.setViewName("proveedores/list");
        return modelAndView;
    }

    private Proveedor getProveedor(int codigo) {
        List<Proveedor> proveedores = getProveedores();
        int indexOf = proveedores.indexOf(new Proveedor(codigo));

        return proveedores.get(indexOf);
    }

    private List<Proveedor> getProveedores() {

        // List<Proveedor> proveedores = (List<Proveedor>)
        // request.getSession().getAttribute("proveedores");

        // if (proveedores == null) {
        List<Proveedor> proveedores = new ArrayList<>();

        proveedores.add(new Proveedor(1,"Juan", "Sánchez Herreros"));
        proveedores.add(new Proveedor(2,"Marcos", "Murillo Luna"));
        proveedores.add(new Proveedor(3,"Marta", "Galletero Zafra"));
        proveedores.add(new Proveedor(4,"Luisa", "Haro Ruíz"));

        // request.getSession().setAttribute("proveedores", proveedores);
        // }

        return proveedores;

    }
}
