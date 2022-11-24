package com.laura.springprojects.tienda.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.laura.springprojects.tienda.model.Usuario;

@Controller
public class WelcomeController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(value="/signin")
    public String signin() {
        return "signin";
    }

    // @PostMapping(path = "/login")
    // public String bienvenido(Model model, Usuario usuario, HttpServletRequest httpServletRequest){

    //     String message = messageSource.getMessage("saludar.usuario", new String[]{usuario.getUsuario()}, LocaleContextHolder.getLocale());
    //     model.addAttribute("greetings", message);

    //     HttpSession session = httpServletRequest.getSession();
    //     session.setAttribute("usuario", usuario);

    //     return "login";
    // }

    @PostMapping(path = "/login")
    public String bienvenido(Model model, Usuario usuario, HttpSession session){
        String message = messageSource.getMessage("saludar.usuario", new String[]{usuario.getUsuario()}, LocaleContextHolder.getLocale());
        model.addAttribute("greetings", message);

        session.setAttribute("usuario", usuario);

        return "login";
    }

    @GetMapping(value="/welcome")
    public String welcome() {
        return "welcome";
    }

    @GetMapping(value="/logout")
    public String logout(HttpSession session) {
        session.invalidate();

        return "signin";
    }
}
