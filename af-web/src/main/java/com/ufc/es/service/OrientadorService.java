package com.ufc.es.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.es.model.Orientador;
import com.ufc.es.repository.OrientadorRepository;

@Service
public class OrientadorService {
	@Autowired
	OrientadorRepository orientadorRepo;
	
	public List<Orientador> lista(){
		return orientadorRepo.findAll();
	}
}
