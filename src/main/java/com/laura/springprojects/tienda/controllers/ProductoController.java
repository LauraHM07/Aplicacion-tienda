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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.laura.springprojects.tienda.model.Producto;
import com.laura.springprojects.tienda.services.ProductosService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    ProductosService productosService;

    @GetMapping(value = "/list")
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
    public ModelAndView save(Producto producto, @RequestParam("imagenForm") MultipartFile multipartFile)
            throws IOException {

        byte[] imagen = multipartFile.getBytes();

        producto.setFoto(imagen);

        productosService.insert(producto);

        List<Producto> productos = productosService.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productos", productos);
        modelAndView.setViewName("productos/list");
        return modelAndView;
    }

    @PostMapping(path = { "/update" })
    public ModelAndView update(Producto producto, @RequestParam("imagenForm") MultipartFile multipartFile) throws IOException {

        byte[] imagen = multipartFile.getBytes();

        producto.setFoto(imagen);
        
        productosService.update(producto);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit?codigo=" + producto.getCodigo());
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
}
