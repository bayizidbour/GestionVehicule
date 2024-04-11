package com.gestionParc.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Camion extends Vehi4Roues {

	@Min(7)
	private double longeur;

	public Camion(Integer idVehicule, String couleur, double poids, double prixJournalier,
			List<Commentaire> commentaires, List<Reservation> reservations, Agence agence) {
		super(idVehicule, couleur, poids, prixJournalier, commentaires, reservations, agence);
		
	}
	
	

	
	
}
