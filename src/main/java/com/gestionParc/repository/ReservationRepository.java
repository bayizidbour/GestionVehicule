package com.gestionParc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionParc.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, String> {

}
