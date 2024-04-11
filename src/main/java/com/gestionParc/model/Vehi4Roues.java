package com.gestionParc.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Vehi4Roues extends Vehicule {

	@Min (2)		
	@Max(4)
	private int nbPorte;

	public Vehi4Roues(Integer idVehicule, String couleur, double poids, double prixJournalier,
			List<Commentaire> commentaires, List<Reservation> reservations, Agence agence) {
		super(idVehicule, couleur, poids, prixJournalier, commentaires, reservations, agence);
		
	}

	
	
}
