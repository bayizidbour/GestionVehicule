package com.gestionParc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionParc.model.Commentaire;
import com.gestionParc.repository.CommentaireRepository;

@Service
public class CommentaireService {

	@Autowired
	CommentaireRepository commentaireRepo;
	
	public Commentaire addComment (Commentaire commentaire) {
		return commentaireRepo.save(commentaire);
	}
	
	public void deleteComment (Commentaire commentaire) {
		commentaireRepo.delete(commentaire);
	}
	
	public void deleteCommentById (Integer id) {
		commentaireRepo.deleteById(id);
	}
	
	public List<Commentaire> getAllComments (){
		return commentaireRepo.findAll();
	}
	
	
	public Commentaire getCommentById (Integer id) {
		Optional<Commentaire> optComment = commentaireRepo.findById(id);
		
		return optComment.isPresent() ? optComment.get() : null; 
	}
}
