package com.thevisualcommunicationguy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.thevisualcommunicationguy.models.Quiz;

@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface QuizRepository extends JpaRepository<Quiz, Long> {
	List<Quiz> findByUsername(String username);
}
