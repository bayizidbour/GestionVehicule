package com.gestionParc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionParc.model.Commentaire;

public interface CommentaireRepository extends JpaRepository<Commentaire, Integer> {

}
