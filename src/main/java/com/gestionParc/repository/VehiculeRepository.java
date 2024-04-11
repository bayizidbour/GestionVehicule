package com.gestionParc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionParc.model.Vehicule;

public interface VehiculeRepository extends JpaRepository<Vehicule, Integer> {

}
