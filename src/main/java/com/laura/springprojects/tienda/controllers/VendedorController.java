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

import com.laura.springprojects.tienda.model.Vendedor;

@Controller
@RequestMapping("/vendedores")
public class VendedorController {

    @GetMapping(value="/list")
    public ModelAndView list(Model model) {

        ModelAndView modelAndView = new ModelAndView("vendedores/list");
        modelAndView.addObject("vendedores", getVendedores());
        modelAndView.addObject("title", "vendedores");
        return modelAndView;
    }

    @GetMapping(path = { "/edit/{codigo}" })
    public ModelAndView edit(
            @PathVariable(name = "codigo", required = true) int codigo) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("vendedor", getVendedor(codigo));
        modelAndView.setViewName("vendedores/edit");
        return modelAndView;
    }

    @GetMapping(path = { "/create" })
    public ModelAndView create(Vendedor vendedor) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("vendedor", new Vendedor());
        modelAndView.setViewName("vendedores/new");
        return modelAndView;
    }

    @PostMapping(path = { "/save" })
    public ModelAndView save(Vendedor vendedor) {

        int round = (int) (Math.random()*(100+5));

        vendedor.setCodigo(round);

        List<Vendedor> vendedores = getVendedores();
        vendedores.add(vendedor);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("vendedores", vendedores);
        modelAndView.setViewName("vendedores/list");
        return modelAndView;
    }

    @PostMapping(path = { "/update" })
    public ModelAndView update(Vendedor vendedor) {

        List<Vendedor> vendedores = getVendedores();

        int indexOf = vendedores.indexOf(vendedor);

        vendedores.set(indexOf, vendedor);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("vendedores", vendedores);
        modelAndView.setViewName("vendedores/list");
        return modelAndView;
    }

    @GetMapping(path = { "/delete/{codigo}" })
    public ModelAndView delete(
            @PathVariable(name = "codigo", required = true) int codigo) {

        List<Vendedor> vendedores = getVendedores();
        vendedores.remove(getVendedor(codigo));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("vendedores", vendedores);
        modelAndView.setViewName("vendedores/list");
        return modelAndView;
    }
        

    private Vendedor getVendedor(int codigo){
        List<Vendedor> vendedores = getVendedores();
        int indexOf = vendedores.indexOf(new Vendedor(codigo));

        return vendedores.get(indexOf);

    }

    private List<Vendedor> getVendedores() {

        // List<vendedor> vendedores = (List<vendedor>) request.getSession().getAttribute("vendedores");

        // if (vendedores == null) {
            List<Vendedor> vendedores = new ArrayList<>();

            vendedores.add(new Vendedor(1, "Christian", "Molina Ramírez", "Jefe"));
            vendedores.add(new Vendedor(2, "Miriam", "Maldonado Rosa", "SubJefe"));
            vendedores.add(new Vendedor(3, "Jose Manuel", "Molina Cortés", "Empleado"));
            vendedores.add(new Vendedor(4, "Virginia", "Martos Martín", "Empleado"));
    
            // request.getSession().setAttribute("vendedores", vendedores);
        // }

        return vendedores;
    }
}
