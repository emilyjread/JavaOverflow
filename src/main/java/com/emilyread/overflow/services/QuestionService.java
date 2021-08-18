package com.emilyread.overflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.emilyread.overflow.models.Answer;
import com.emilyread.overflow.models.Question;
import com.emilyread.overflow.repos.AnswerRepo;
import com.emilyread.overflow.repos.QuestionRepo;


@Service
public class QuestionService {
	
	private final QuestionRepo questionRepo;
	private final AnswerRepo answerRepo;
	
	public QuestionService(QuestionRepo questionRepo, AnswerRepo answerRepo) {
		this.questionRepo= questionRepo;
		this.answerRepo= answerRepo;
		
	}
	
	public List<Question> allQuestions() {
	    return questionRepo.findAll();
	}
	
	public Question createQuestion(Question q) {
	    return questionRepo.save(q);
	}
	
	public Question findQuestion(Long id) {
	    Optional<Question> optionalQuestion = questionRepo.findById(id);
	    if(optionalQuestion.isPresent()) {
	        return optionalQuestion.get();
	    } else {
	        return null;
	    }
	}
	
	public Answer findAnswer(Long id) {
	    Optional<Answer> optionalAnswer = answerRepo.findById(id);
	    if(optionalAnswer.isPresent()) {
	        return optionalAnswer.get();
	    } else {
	        return null;
	    }
	}
	
	 public Question updateQuestion(Long questionId, Answer a) {
		 Question thisQuestion = findQuestion(questionId);
		 thisQuestion.getAnswers().add(a);
		 return questionRepo.save(thisQuestion);
	 }


}
