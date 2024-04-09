package com.gestionParc.model;

import java.time.LocalDate;
import java.util.Random;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Reservation {

	@Id
	private String idReservation;
	
	private LocalDate date = LocalDate.now();
	
	private LocalDate dateDebut;
	
	private LocalDate dateFin;
	
	@ManyToOne
	@JoinColumn(name = "idClient")
	private User client;
	
	@ManyToOne
	@JoinColumn(name = "idVehicule")
	private Vehicule vehicule;

	public Reservation() {
		idReservation = generatedId();
	}
	
	public Reservation(User client) {
		idReservation = generatedId();
		this.client = client;
	}
	
	public String generatedId() {
		Random rand = new Random();
		String str = "_";
		
		for (int i = 0; i < 7; i++) 
			str += (char) (rand.nextInt(26) + 65);
		
		
		return date.getDayOfMonth() + "" + date.getMonthValue() + "" + date.getYear() + str;
	}

	@Override
	public String toString() {
		return "Reservation [idReservation=" + idReservation + ", date=" + date + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + ", client=" + client + ", vehicule=" + vehicule + "]";
	}



	
	
}
