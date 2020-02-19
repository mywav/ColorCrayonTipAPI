package com.thevisualcommunicationguy.services;

import java.sql.Date;

import javax.persistence.EntityManager;

import com.thevisualcommunicationguy.models.Quiz;

public class QuizService {
	
	private EntityManager em;
	
	public QuizService(EntityManager em) {
		this.em = em;
	}
	
	public Quiz createQuiz(Long id, String username, String nameofpaper, Date date_taken,
			Integer question01, Integer question02, Integer question03, Integer question04,
			Integer question05, Integer question06, Integer question07, Integer question08, 
			Integer question09, Integer question10) {
	Quiz quiz = new Quiz();
	quiz.setId(id);
	quiz.setUsername(username);
	quiz.setNameofpaper(nameofpaper);
	quiz.setDateTaken(date_taken);
	quiz.setQuestion01(question01);
	quiz.setQuestion02(question02);
	quiz.setQuestion03(question03);
	quiz.setQuestion04(question04);
	quiz.setQuestion05(question05);
	quiz.setQuestion06(question06);
	quiz.setQuestion07(question07);
	quiz.setQuestion08(question08);
	quiz.setQuestion09(question09);
	quiz.setQuestion10(question10);
    em.persist(quiz);
    return quiz;
	}
	
	public Quiz updateAnswer01(Long id, Integer answer) {
		Quiz quiz = em.find(Quiz.class,  id);
		if (quiz != null)
			quiz.setQuestion01(answer);
		return quiz;	
	}
}
