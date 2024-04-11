package com.gestionParc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionParc.model.Vehicule;
import com.gestionParc.repository.VehiculeRepository;

@Service
public class VehiculeService {

	@Autowired
	VehiculeRepository vehiculeRepo;
	
	public Vehicule addVehicule(Vehicule vehicule) {
		return vehiculeRepo.save(vehicule);
	}
	
	public void deleteVehicule (Vehicule vehicule) {
		vehiculeRepo.delete(vehicule);
	}
	
	public void deletevehiculeById (Integer id) {
		vehiculeRepo.deleteById(id);
	}
	
	public List<Vehicule> getAllVehicules(){
		return vehiculeRepo.findAll();
	}
	
	public Vehicule getVehiculeById (Integer Id) {
		Optional<Vehicule> optVehi = vehiculeRepo.findById(Id);
		return optVehi.isPresent()? optVehi.get():null;
	}
}
