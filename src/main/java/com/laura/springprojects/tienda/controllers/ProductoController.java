package com.laura.springprojects.tienda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laura.springprojects.tienda.model.Producto;
import com.laura.springprojects.tienda.services.ProductosService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    ProductosService productosService;

    @GetMapping(value="/list")
    public ModelAndView list(Model model) {

        List<Producto> productos = productosService.findAll();
        
        ModelAndView modelAndView = new ModelAndView("productos/list");
        modelAndView.addObject("productos", productos);
        modelAndView.addObject("title", "Productos");
        return modelAndView;
    }

    @GetMapping(path = { "/edit" })
    public ModelAndView edit(
            @RequestParam(name = "codigo", required = true) int codigo) {

        Producto producto = productosService.findById(codigo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("producto", producto);
        modelAndView.setViewName("productos/edit");
        return modelAndView;
    }

    @GetMapping(path = { "/create" })
    public ModelAndView create(Producto producto) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("producto", new Producto());
        modelAndView.setViewName("productos/new");
        return modelAndView;
    }

    @PostMapping(path = { "/save" })
    public ModelAndView save(Producto producto) {
        
        productosService.insert(producto);

        List<Producto> productos = productosService.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productos", productos);
        modelAndView.setViewName("productos/list");
        return modelAndView;
    }

    @PostMapping(path = { "/update" })
    public ModelAndView update(Producto producto) {

        productosService.update(producto);

        List<Producto> productos = productosService.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productos", productos);
        modelAndView.setViewName("productos/list");
        return modelAndView;
    }

    @GetMapping(path = { "/delete/{codigo}" })
    public ModelAndView delete(
            @PathVariable(name = "codigo", required = true) int codigo) {

        productosService.delete(codigo);

        List<Producto> productos = productosService.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productos", productos);
        modelAndView.setViewName("productos/list");
        return modelAndView;
    }

    // private Producto getProducto(int codigo){
    //     List<Producto> productos = getProductos();
    //     int indexOf = productos.indexOf(new Producto(codigo));

    //     return productos.get(indexOf);

    // }

    // private List<Producto> getProductos() {

    //     ArrayList<Producto> productos = new ArrayList<Producto>();

    //     productos.add(new Producto(0, "Cocacola",
    //             "Coca-Cola es una bebida azucarada gaseosa vendida a nivel mundial en tiendas, restaurantes y máquinas expendedoras en más de doscientos países o territorios",
    //             1.5));
    //     productos.add(new Producto(1, "Pepsi",
    //             "Pepsi es una bebida azucarada gaseosa vendida a nivel mundial en tiendas, restaurantes y máquinas expendedoras en más de doscientos países o territorios",
    //             1.2));
    //     productos.add(new Producto(2, "Fanta",
    //             "Fanta es una bebida azucarada gaseosa vendida a nivel mundial en tiendas, restaurantes y máquinas expendedoras en más de doscientos países o territorios",
    //             1.0));
    //     productos.add(new Producto(3, "Sprite",
    //             "Seven up es una bebida azucarada gaseosa vendida a nivel mundial en tiendas, restaurantes y máquinas expendedoras en más de doscientos países o territorios",
    //             1.1));

    //     return productos;

    // }

}
