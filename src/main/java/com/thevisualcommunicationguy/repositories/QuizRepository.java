package com.thevisualcommunicationguy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thevisualcommunicationguy.models.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
	List<Quiz> findByUsername(String username);
}
