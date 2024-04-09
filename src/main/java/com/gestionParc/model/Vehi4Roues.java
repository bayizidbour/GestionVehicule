package com.gestionParc.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Vehi4Roues extends Vehicule {

	@Size(min = 2, max = 4)
	@Column(length = 4)
	private int nbPorte;

	public Vehi4Roues(Integer idVehicule, String couleur, double poids, double prixJournalier,
			List<Commentaire> commentaires, List<Reservation> reservations, @Size(min = 2, max = 4) int nbPorte) {
		super(idVehicule, couleur, poids, prixJournalier, commentaires, reservations);
		this.nbPorte = nbPorte;
	}
	
	
}
