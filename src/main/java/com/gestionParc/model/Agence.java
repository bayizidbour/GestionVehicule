package com.gestionParc.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Agence {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAgence;
	
	@Size(min = 5, max = 20)
	@Column(length = 20, nullable = false)
	private String nomAgence;
	
	@Column(length = 30)
	private  String email;
	
	@Size(min = 1,  max= 6)
	@Column(length = 6, nullable = false)
	private int rue;
	
	@Size(min = 6,  max= 30)
	@Column(length = 30, nullable =false)
	private String libelleRue;
	
	@Size(min = 3, max= 20)
	@Column(length = 20, nullable =false)
	private String ville;
	
	@Column(nullable = false)
	@Pattern(regexp = "^[0-9]{5}$", message = "Le code postal doit être composé de 5 chiffres")
	private int cp;
	
	@OneToMany (mappedBy = "agence")
	private List<Vehicule> vehicules;
	
	@OneToMany (mappedBy = "agence")
	private	List<User> users;
}
