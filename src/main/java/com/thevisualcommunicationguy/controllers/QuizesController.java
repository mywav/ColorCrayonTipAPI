package com.thevisualcommunicationguy.controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.thevisualcommunicationguy.models.Quiz;
import com.thevisualcommunicationguy.repositories.QuizRepository;

@RestController
@RequestMapping("/api/v1/quizes")
public class QuizesController {	
	
	@Autowired
	private DataSource dataSource;

	@Autowired
	private QuizRepository quizRepository;

	@GetMapping
	public List<Quiz> list() {
		return quizRepository.findAll(Sort.by(Sort.Direction.ASC, "rowid"));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Quiz quiz) {
		
			try {
				Connection connection = dataSource.getConnection();
				Statement statement = connection.createStatement();
				statement.execute(
						"INSERT INTO quiz (rowid) VALUES ('" + quiz.getId() + "')"
				);
				statement.close();
				connection.close();
			}
		catch (SQLException e) {
				e.printStackTrace();
			}		
		quizRepository.save(quiz);
		}
	

	@GetMapping("/{rowid}")
	public Quiz get(@PathVariable("rowid") long rowid) {
		return quizRepository.getOne(rowid);
	}
	
	@GetMapping("/username/{username}")
	public List<Quiz> listByUsername(@PathVariable("username") String username) {
		return quizRepository.findByUsername(username);
	}
	
	@PutMapping("/{rowid}")
	@ResponseStatus(HttpStatus.OK) 
	public Quiz merge(@RequestBody Quiz quiz, @PathVariable("rowid") long id) {
		
		if (quiz.getDateTaken() != null)
			try {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
				Connection connection = dataSource.getConnection();
				Statement statement = connection.createStatement();
				statement.executeUpdate(
						"UPDATE quiz SET date_taken = " + simpleDateFormat.format(quiz.getDateTaken()) + " WHERE rowid = " +
						quiz.getId()
					);
				statement.close();
				connection.close();
				quizRepository.save(quiz);
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (quiz.getQuestion01() != null)
			try {
				Connection connection = dataSource.getConnection();
				Statement statement = connection.createStatement();
				statement.executeUpdate(
						"UPDATE quiz SET question01 = " +
						quiz.getQuestion01() + " WHERE rowid = " +
						quiz.getId()
					);
				statement.close();
				connection.close();
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (quiz.getQuestion02() != null)
			try {
				Connection connection = dataSource.getConnection();
				Statement statement = connection.createStatement();
				statement.executeUpdate(
						"UPDATE quiz SET question02 = " +
						quiz.getQuestion02() + " WHERE rowid = " +
						quiz.getId()
					);
				statement.close();
				connection.close();
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (quiz.getQuestion03() != null)
			try {
				Connection connection = dataSource.getConnection();
				Statement statement = connection.createStatement();
				statement.executeUpdate(
						"UPDATE quiz SET question03 = " +
						quiz.getQuestion03() + " WHERE rowid = " +
						quiz.getId()
					);
				statement.close();
				connection.close();
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (quiz.getQuestion04() != null)
				try {
					Connection connection = dataSource.getConnection();
					Statement statement = connection.createStatement();
					statement.executeUpdate(
							"UPDATE quiz SET question04 = " +
							quiz.getQuestion04() + " WHERE rowid = " +
							quiz.getId()
						);
					statement.close();
					connection.close();
				}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		if (quiz.getQuestion05() != null)
			try {
				Connection connection = dataSource.getConnection();
				Statement statement = connection.createStatement();
				statement.executeUpdate(
						"UPDATE quiz SET question05 = " +
						quiz.getQuestion05() + " WHERE rowid = " +
						quiz.getId()
					);
				statement.close();
				connection.close();
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (quiz.getQuestion06() != null)
			try {
				Connection connection = dataSource.getConnection();
				Statement statement = connection.createStatement();
				statement.executeUpdate(
						"UPDATE quiz SET question06 = " +
						quiz.getQuestion06() + " WHERE rowid = " +
						quiz.getId()
					);
				statement.close();
				connection.close();
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (quiz.getQuestion07() != null)
			try {
				Connection connection = dataSource.getConnection();
				Statement statement = connection.createStatement();
				statement.executeUpdate(
						"UPDATE quiz SET question07 = " +
						quiz.getQuestion07() + " WHERE rowid = " +
						quiz.getId()
					);
				statement.close();
				connection.close();
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (quiz.getQuestion08() != null)
			try {
				Connection connection = dataSource.getConnection();
				Statement statement = connection.createStatement();
				statement.executeUpdate(
						"UPDATE quiz SET question08 = " +
						quiz.getQuestion08() + " WHERE rowid = " +
						quiz.getId()
					);
				statement.close();
				connection.close();
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (quiz.getQuestion09() != null)
			try {
				Connection connection = dataSource.getConnection();
				Statement statement = connection.createStatement();
				statement.executeUpdate(
						"UPDATE quiz SET question09 = " +
						quiz.getQuestion09() + " WHERE rowid = " +
						quiz.getId()
					);
				statement.close();
				connection.close();
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (quiz.getQuestion10() != null)
			try {
				Connection connection = dataSource.getConnection();
				Statement statement = connection.createStatement();
				statement.executeUpdate(
						"UPDATE quiz SET question10 = " +
						quiz.getQuestion10() + " WHERE rowid = " +
						quiz.getId()
					);
				statement.close();
				connection.close();
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (quiz.getUsername() != null)
			try {
				Connection connection = dataSource.getConnection();
				Statement statement = connection.createStatement();
				statement.executeUpdate(
						"UPDATE quiz SET username = " +
						quiz.getUsername().toString() + " WHERE rowid = " +
						quiz.getId()
					);
				statement.close();
				connection.close();
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (quiz.getNameofpaper() != null)
			try {
				Connection connection = dataSource.getConnection();
				Statement statement = connection.createStatement();
				statement.executeUpdate(
						"UPDATE quiz SET nameofpaper = " +
						quiz.getNameofpaper().toString() + " WHERE rowid = " +
						quiz.getId()
					);
				statement.close();
				connection.close();
			}
		catch (SQLException e) {
			e.printStackTrace();
		}		
		return quiz;
	}
}
