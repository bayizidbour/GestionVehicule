package com.gestionParc.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
public abstract class Vehicule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVehicule;
	
	
	private String couleur;
	
	@Min((long) 80.0)
	private double poids;
	
	@Min((long) 45.0)
	private double prixJournalier; 
	
	@OneToMany(mappedBy = "vehicule")
	private List<Commentaire> commentaires;
	
	@OneToMany(mappedBy = "vehicule")
	private List<Reservation> reservations;

	
	
	
}
