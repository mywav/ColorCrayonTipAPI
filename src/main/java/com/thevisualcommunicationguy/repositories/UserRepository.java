package com.thevisualcommunicationguy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thevisualcommunicationguy.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
