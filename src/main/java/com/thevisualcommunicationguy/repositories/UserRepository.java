package com.thevisualcommunicationguy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.thevisualcommunicationguy.models.User;

@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface UserRepository extends JpaRepository<User, Long>{

}
