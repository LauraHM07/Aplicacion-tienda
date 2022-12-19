package com.laura.springprojects.tienda.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @GetMapping(value = "/cesta/{pedido}")
    public ModelAndView cesta() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("");

        return modelAndView;
    }
}
