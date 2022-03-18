package com.celulardesktop.projeto.controllers;
import com.celulardesktop.projeto.models.Aplicacao;
import com.celulardesktop.projeto.models.Celular;
import com.celulardesktop.projeto.repository.AplicacaoRepository;
import com.celulardesktop.projeto.repository.CelularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/celulares")
public class CelularController {

    @Autowired
    CelularRepository celularRepository;

    @Autowired
    AplicacaoRepository aplicacaoRepository;

    @GetMapping("")
    public ModelAndView listar(){

        ModelAndView modelAndView = new ModelAndView("celular/celulares");
        List<Celular> celularList = celularRepository.findAll();

        modelAndView.addObject("celulares", celularList);
        return modelAndView;

    }

    @GetMapping("/{id}")
    public ModelAndView detalharCelular(@PathVariable Long id){

        Celular celular = celularRepository.findCelularById(id);

        ModelAndView modelAndView  = new ModelAndView("celular/celular-detalhe");
        modelAndView.addObject("celular", celular);

        List<Aplicacao> aplicacaoList = aplicacaoRepository.findAll();
        modelAndView.addObject("aplicacoes", celular.getAplicacoes());

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView adicionar(){

        ModelAndView modelAndView = new ModelAndView("celular/celular-detalhe");

        Celular celular = new Celular();
        modelAndView.addObject("celular", celular);

        List<Aplicacao> aplicacaoList = aplicacaoRepository.findAll();
        modelAndView.addObject("aplicacoes", aplicacaoList);



        return modelAndView;

    }

    @PostMapping("/add")
    public String adicionarCelular(Celular celular){

        celularRepository.save(celular);
        return "redirect:/celulares";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id){

        Celular celular = celularRepository.findCelularById(id);
        celularRepository.delete(celular);
        return "redirect:/celulares";
    }

}

