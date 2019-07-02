package com.ufc.es.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.es.model.Bolsista;
import com.ufc.es.repository.BolsistaRepository;

@Service
public class BolsistaService {
	@Autowired
	BolsistaRepository bolsistaRepo;
	
	public void cadastrar(Bolsista bol) {
		bol.setSenha(bol.getMatricula().toString()+bol.getNome());
		bol.setLogin(bol.getMatricula().toString());
		bolsistaRepo.save(bol);
	}
	
	public List<Bolsista> lista(){
		return bolsistaRepo.findAll();
	}

	public Bolsista buscarPorMatricula(Long matricula) {
		return bolsistaRepo.getOne(matricula);
	}

	public void apagar(Long matricula) {
		bolsistaRepo.deleteById(matricula);
		
	}
}
