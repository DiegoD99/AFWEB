package com.ufc.es.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Orientador {

	@Id
	private Long matricula;
	
	private String nome;

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
