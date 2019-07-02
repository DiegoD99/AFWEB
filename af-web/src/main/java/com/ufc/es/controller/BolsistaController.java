package com.ufc.es.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ufc.es.model.Bolsista;
import com.ufc.es.model.Orientador;
import com.ufc.es.service.BolsistaService;
import com.ufc.es.service.OrientadorService;

@Controller
public class BolsistaController {
	@Autowired
	BolsistaService bolsistaServ;
	
	@Autowired
	OrientadorService orientadorServ;
	
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("Index");
		return mv;
	}
	@RequestMapping("/bolsista/registro")
	public ModelAndView cadastro() {
		ModelAndView mv = new ModelAndView("Cadastro");
		List<Orientador> orientadores = orientadorServ.lista();
		mv.addObject("orientadores", orientadores);
		mv.addObject("bolsista", new Bolsista());
		return mv;
	}
	@RequestMapping("/bolsista/salvar")
	public ModelAndView salvar(Bolsista bol, BindingResult result) {
		ModelAndView mv = new ModelAndView("Cadastro");
		
		if(result.hasErrors()) {
			return mv;
		}
		mv.addObject("mensagem", "Cliente cadastrado com sucesso!");
		
		bolsistaServ.cadastrar(bol);
		
		return mv;
	}
	
	@RequestMapping("/bolsista/listagem")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("ListaControle");
		List<Bolsista> bolsistas = bolsistaServ.lista();
		mv.addObject("bolsistas", bolsistas);
		return mv;
	}
	
	@RequestMapping("/bolsista/atualizar/{matricula}")
	public ModelAndView atualizar(@PathVariable Long matricula) {
		ModelAndView mv = new ModelAndView("Cadastro"); 
		Bolsista bolsista = bolsistaServ.buscarPorMatricula(matricula);
		mv.addObject("bolsista", bolsista);
		List<Orientador> orientadores = new ArrayList<Orientador>();
		mv.addObject("orientadores",orientadores);
		return mv;
	}
	
	@RequestMapping("/bolsista/apagar/{matricula}")
	public ModelAndView apagar(@PathVariable Long matricula) {
		ModelAndView mv = new ModelAndView("redirect:/bolsista/listagem");
		bolsistaServ.apagar(matricula);
		return mv;
	}
	
}
