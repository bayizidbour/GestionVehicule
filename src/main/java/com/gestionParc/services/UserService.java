package com.gestionParc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionParc.model.User;
import com.gestionParc.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	public User addUser (User user) {
		return userRepo.save(user);
	}
	
	public void deleteUser (User user) {
		userRepo.delete(user);
	}
	
	public void deleteUserById (Integer id) {
		userRepo.deleteById(id);
	}
	
	public User getUserById (Integer id) {
		Optional<User> optUser = userRepo.findById(id);
		
		return optUser.isPresent()? optUser.get():null;
	}
	
	public User updateUser (Integer id, User userToUp) {
		Optional<User> optUser = userRepo.findById(id);
		 
		if (optUser.isPresent()) {
			User userInBd = optUser.get();
			userInBd.setPrenom(userToUp.getPrenom());
			userInBd.setNom(userToUp.getNom());
			userInBd.setRole(userToUp.getRole());
			
			return userRepo.save(userInBd);
		}
		return null;
	}
	
	public List<User> getAllUsers (){
		return userRepo.findAll();
	}
}
