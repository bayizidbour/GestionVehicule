package com.gestionParc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionParc.model.Reservation;
import com.gestionParc.repository.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	ReservationRepository reservationRepository;
	
	
	public Reservation addReservation (Reservation reservation) {
		return reservationRepository.save(reservation);
	}
	
	public void deleteReservation (Reservation reservation) {
		reservationRepository.delete(reservation);
	}
	
	
	
}
