package com.gestionParc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionParc.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
