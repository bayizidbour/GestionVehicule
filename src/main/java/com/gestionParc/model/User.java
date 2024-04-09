package com.gestionParc.model;


import java.util.List;

import com.gestionParc.enums.Role;
import com.gestionParc.enums.Sexe;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUser;
	
	
	@Size(min = 2, max = 30, message = "Le prénom doit contenir entre 2 et 30 caractères")
	@Pattern(regexp = "^[a-z]", message = "Le prénom doit être en minuscules ")
	private String prenom;
	
	@Size(min = 2, max = 20)
	@Column(length = 20)
	private String nom;
	
	@NotBlank(message = "Login est obligatoire")
	@Size(min = 6, max = 8, message = "Login doit contenir entre 6 et 8 caractères")
	@Pattern(regexp = "^[a-z]+$", message = "Login doit être en minuscules sans espaces")
	@Column(length = 8, unique = true, nullable = false)
	private String login;
	
	@Size(min = 8, max = 15)
	@Column(length = 15, nullable = false)
	private String mdp;
	
	@Column( length = 30 )
	private String email;
	
	@Size(min = 5, max = 10)
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Size(min = 8, max = 10)
	@Enumerated(EnumType.STRING)
	private Sexe sexe;
	
	@OneToMany(mappedBy = "client")
	private List<Reservation> reservations;
	
	@OneToMany(mappedBy = "client")
	private List<Commentaire> commentaires;

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", prenom=" + prenom + ", nom=" + nom + ", login=" + login + ", mdp=" + mdp
				+ ", email=" + email + ", role=" + role + ", sexe=" + sexe + ", reservations=" + reservations
				+ ", commentaires=" + commentaires + "]";
	}
	
	
}
