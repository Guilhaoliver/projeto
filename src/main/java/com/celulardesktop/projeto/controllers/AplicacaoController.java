package com.celulardesktop.projeto.controllers;

import com.celulardesktop.projeto.models.Aplicacao;
import com.celulardesktop.projeto.models.Celular;
import com.celulardesktop.projeto.repository.AplicacaoRepository;
import com.celulardesktop.projeto.repository.CelularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/aplicacoes")
public class AplicacaoController {

    @Autowired
    AplicacaoRepository aplicacaoRepository;

    @Autowired
    CelularRepository celularRepository;

    @GetMapping("")
    public ModelAndView listar(){

        ModelAndView modelAndView = new ModelAndView("aplicacao/aplicacoes");
        List<Aplicacao> aplicacaoList = aplicacaoRepository.findAll();
        modelAndView.addObject("aplicacoes", aplicacaoList);
        return modelAndView;

    }

    @GetMapping("/{id}")
    public ModelAndView detalharUsuario(@PathVariable Long id){

        Aplicacao aplicacaoList = aplicacaoRepository.findAplicacaoById(id);
        ModelAndView modelAndView  = new ModelAndView("aplicacao/aplicacao-detalhe");
        modelAndView.addObject("aplicacao", aplicacaoList);

        List<Celular> celularList = celularRepository.findAll();
        modelAndView.addObject("celulares", celularList);

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView adicionar(){

        ModelAndView modelAndView = new ModelAndView("aplicacao/aplicacao-detalhe");
        Aplicacao aplicacao = new Aplicacao();
        modelAndView.addObject("aplicacao", aplicacao);

        List<Celular> celularList = celularRepository.findAll();
        modelAndView.addObject("celulares",celularList);
        return modelAndView;
    }

    @PostMapping("/add")
    public String adicionarUsuario(Aplicacao aplicacao){

        aplicacaoRepository.save(aplicacao);
        return "redirect:/aplicacoes";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id){

        Aplicacao aplicacao = aplicacaoRepository.findAplicacaoById(id);
        aplicacaoRepository.delete(aplicacao);
        return "redirect:/aplicacoes";
    }
}