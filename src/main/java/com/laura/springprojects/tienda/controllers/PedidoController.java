package com.laura.springprojects.tienda.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.laura.springprojects.tienda.model.Cliente;
import com.laura.springprojects.tienda.model.Pedido;
import com.laura.springprojects.tienda.services.ClientesService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    ClientesService clientesService;

    @GetMapping(value = "/cesta/{codigo}")
    public ModelAndView cesta(@PathVariable(name = "codigo", required = true) int codigo, HttpSession session) {
        Cliente cliente = clientesService.findById(codigo);

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        
        session.setAttribute("pedido", pedido);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cesta");
        modelAndView.addObject("pedido", pedido);

        return modelAndView;
    }
}
