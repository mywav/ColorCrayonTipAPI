package com.thevisualcommunicationguy.controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.thevisualcommunicationguy.models.User;
import com.thevisualcommunicationguy.repositories.UserRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/users")
public class UsersController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DataSource dataSource;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<User> list() {
		return userRepository.findAll(Sort.by(Sort.Direction.ASC, "rowid"));
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody User user) {
			try {				
				System.out.println(user.getUsername());
				Connection connection = dataSource.getConnection();
				Statement statement = connection.createStatement();
				statement.execute(
						"INSERT INTO user (username) VALUES ('" + user.getUsername() + "')"
				);
				statement.close();
				connection.close();
				System.out.println("Working");
			}
		catch (SQLException e) {
				e.printStackTrace();
			}		
		}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping("/{rowid}")
	@ResponseStatus(HttpStatus.OK) 
	public User merge(@RequestBody User user, @PathVariable("rowid") long id) {
		if ((user.getId() != null) && (user.getUsername() != null))
		try
		{
			Connection connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate(
					"UPDATE user SET username = '" + user.getUsername() + "' WHERE rowid = " + user.getId()
		);
			statement.close();
			connection.close();
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
			userRepository.save(user);		
		return user;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/{rowid}")
	@ResponseStatus(HttpStatus.OK)
	public User get(@PathVariable("rowid") long id) {
		return userRepository.getOne(id);
	}	
}
