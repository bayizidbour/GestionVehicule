package com.gestionParc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionParc.model.Agence;
import com.gestionParc.model.User;
import com.gestionParc.repository.AgenceRepository;

@Service
public class AgenceService {

	@Autowired
	AgenceRepository agenceRepository;
	
	
	public Agence addAgence (Agence agence) {
		return agenceRepository.save(agence);
	}
	
	public void deleteAgence (Agence agence) {
		agenceRepository.delete(agence);
	}
	
	public void deleteAgenceById (Integer id) {
		agenceRepository.deleteById(id);
	}
	
	public Agence getAgenceById (Integer id) {
		Optional<Agence> optAg = agenceRepository.findById(id);
		return optAg.isPresent()? optAg.get(): null;
	}
	
	public List<Agence> getAllAg () {
		return agenceRepository.findAll();
	}
	
	public Agence updateAgence (Integer id, Agence agenceToUp) {
		Optional<Agence> optag = agenceRepository.findById(id);
		 
		if (optag.isPresent()) {
			Agence agenceInBd = optag.get();
			agenceInBd.setNomAgence(agenceToUp.getNomAgence());
			agenceInBd.setEmail(agenceToUp.getEmail());
			agenceInBd.setRue(agenceToUp.getRue());
			agenceInBd.setLibelleRue(agenceToUp.getLibelleRue());
			agenceInBd.setVille(agenceToUp.getVille());
			
			return agenceRepository.save(agenceInBd);
		}
		return null;
	}
}
