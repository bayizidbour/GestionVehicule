package com.gestionParc.model;

import java.util.List;

import com.gestionParc.enums.Type2Roues;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Vehi2Roues extends Vehicule {

	@Size(min = 1, max = 4)
	@Column(length = 4, nullable = false)
	private int nbCylindre;
	
	@Enumerated(EnumType.STRING)
	@Size(min = 4, max = 7)
	private Type2Roues type2Roues;

	public Vehi2Roues(Integer idVehicule, String couleur, double poids, double prixJournalier,
			List<Commentaire> commentaires, List<Reservation> reservations) {
		super(idVehicule, couleur, poids, prixJournalier, commentaires, reservations);
		
	}
	
	
}
