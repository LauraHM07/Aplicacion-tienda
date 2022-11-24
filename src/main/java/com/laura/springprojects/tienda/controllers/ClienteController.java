package com.laura.springprojects.tienda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.laura.springprojects.tienda.model.Cliente;
import com.laura.springprojects.tienda.services.ClientesService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClientesService clientesService;

    @GetMapping(value="/list")
    public ModelAndView list(Model model) {

        List<Cliente> clientes = clientesService.findAll();

        ModelAndView modelAndView = new ModelAndView("clientes/list");
        modelAndView.addObject("clientes", clientes);
        modelAndView.addObject("title", "clientes");
        return modelAndView;
    }

    @GetMapping(path = { "/edit/{codigo}" })
    public ModelAndView edit(
            @PathVariable(name = "codigo", required = true) int codigo) {

        Cliente cliente = clientesService.findById(codigo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cliente", cliente);
        modelAndView.setViewName("clientes/edit");
        return modelAndView;
    }

    @GetMapping(path = { "/create" })
    public ModelAndView create(Cliente cliente) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cliente", new Cliente());
        modelAndView.setViewName("clientes/new");
        return modelAndView;
    }

    @PostMapping(path = { "/save" })
    public ModelAndView save(Cliente cliente) {
        
        clientesService.insert(cliente);

        List<Cliente> clientes = clientesService.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("clientes", clientes);
        modelAndView.setViewName("clientes/list");
        return modelAndView;
    }

    @PostMapping(path = { "/update" })
    public ModelAndView update(Cliente cliente) {

        clientesService.update(cliente);

        List<Cliente> clientes = clientesService.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("clientes", clientes);
        modelAndView.setViewName("clientes/list");
        return modelAndView;
    }

    @GetMapping(path = { "/delete/{codigo}" })
    public ModelAndView delete(
            @PathVariable(name = "codigo", required = true) int codigo) {

        clientesService.delete(codigo);

        List<Cliente> clientes = clientesService.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("clientes", clientes);
        modelAndView.setViewName("clientes/list");
        return modelAndView;
    }
        

    // private Cliente getCliente(int codigo){
    //     List<Cliente> clientes = clientesService.findAll();
    //     int indexOf = clientes.indexOf(new Cliente(codigo));

    //     return clientes.get(indexOf);

    // }

    // private List<Cliente> getClientes() {

    //     // List<Cliente> clientes = (List<Cliente>) request.getSession().getAttribute("clientes");

    //     // if (clientes == null) {
    //         List<Cliente> clientes = new ArrayList<>();

    //         clientes.add(new Cliente(1, "Laura", "Haro Molina", "laurahm@gmail.com","12345678Z", "111111111","Calle 1", false));
    //         clientes.add(new Cliente(2, "Pepe", "Pérez Pérez", "pepepp@gmail.com", "12345678Z", "222222222","Calle 2", true));
    //         clientes.add(new Cliente(3, "María", "Casas Martínez", "mariacm@gmail.com", "12345678Z", "333333333","Calle 3", false));
    //         clientes.add(new Cliente(4, "Luis", "López López", "luisll@gmail.com", "12345678Z", "444444444","Calle 4", false));
    
    //         // request.getSession().setAttribute("clientes", clientes);
    //     // }

    //     return clientes;
    // }
}
