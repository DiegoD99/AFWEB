package com.ufc.es.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufc.es.model.Bolsista;

@Repository
public interface BolsistaRepository extends JpaRepository<Bolsista,Long>{

}
