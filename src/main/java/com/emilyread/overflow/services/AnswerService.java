package com.emilyread.overflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.emilyread.overflow.models.Answer;
import com.emilyread.overflow.repos.AnswerRepo;

@Service
public class AnswerService {
	
	private final AnswerRepo answerRepo;
	
	public AnswerService(AnswerRepo answerRepo) {
		this.answerRepo= answerRepo;
	}
	
	public List<Answer> allAnswers() {
	    return answerRepo.findAll();
	}
	
	public Answer createAnswer(Answer a) {
	    return answerRepo.save(a);
	}
	
	public Answer findAnswer(Long id) {
	    Optional<Answer> optionalAnswer = answerRepo.findById(id);
	    if(optionalAnswer.isPresent()) {
	        return optionalAnswer.get();
	    } else {
	        return null;
	    }
	}
	
	public List<Answer> answersByQuestion(Long id) {
        return answerRepo.findByQuestionId(id);
    }


}
