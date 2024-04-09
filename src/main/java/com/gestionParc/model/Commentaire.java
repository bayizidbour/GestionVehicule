package com.gestionParc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Commentaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idComment;
	
	@Size(min = 6, max = 300)
	@Column(length = 300)
	private String contenu;
	
	@ManyToOne
	@JoinColumn(name = "idClient")
	private User client;
	
	@ManyToOne
	@JoinColumn(name = "idVehicule")
	private Vehicule vehicule;
	
	
}
