package com.gestionParc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionParc.model.Agence;

public interface AgenceRepository extends JpaRepository<Agence, Integer> {

	
}
