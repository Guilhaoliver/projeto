package com.celulardesktop.projeto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class SiteController {

    @GetMapping()
    public ModelAndView dashBoard(){

        return new ModelAndView("dashboard");
    }

}


