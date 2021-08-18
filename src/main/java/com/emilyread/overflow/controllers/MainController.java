package com.emilyread.overflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.emilyread.overflow.models.Answer;
import com.emilyread.overflow.models.Question;
import com.emilyread.overflow.services.AnswerService;
import com.emilyread.overflow.services.QuestionService;
import com.emilyread.overflow.services.TagService;


@Controller
public class MainController {
	
	private QuestionService questionService;
	private AnswerService answerService;
	private TagService tagService;
	

	public MainController(QuestionService questionService, AnswerService answerService, TagService tagService) {
		this.questionService = questionService;
		this.answerService = answerService;
		this.tagService = tagService;
	}
	
	//landing page(Dashboard)- all questions
	@GetMapping("/questions")
	public String dashboard(Model model) {
		List<Question> questions= questionService.allQuestions();
		model.addAttribute("questions", questions);
		return "dashboard.jsp";
	}
	
	//create question
	@RequestMapping("/questions/new")
	public String newQuestion(@ModelAttribute("q") Question q) {
		return "newquestion.jsp";
		
	}
	
	@RequestMapping(value= "/questions", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("q") Question q, BindingResult result){
		if(result.hasErrors()) {
			return "newquestion.jsp";
		}
		else {
			//add a tag
			questionService.createQuestion(q);
			return "redirect:/questions";
		}
		
	}
	
	//show question, answer question
	
	@RequestMapping("/questions/{id}")
	public String showQuestion(@ModelAttribute("ans") Answer ans, @PathVariable("id") Long id, Model model) {
		Question question = questionService.findQuestion(id);
		model.addAttribute("question", question);
		
		
		return "showquestion.jsp";
		
	}
	
	
	@RequestMapping(value= "/addAnswer", method=RequestMethod.POST)
	public String createanswer(@Valid @ModelAttribute("ans") Answer ans, BindingResult result, @RequestParam("question") Long q_id, Model model){
		if(result.hasErrors()) {
			Question question = questionService.findQuestion(q_id);
			model.addAttribute("question", question);
			return "showquestion.jsp";
		}
		else {
			
			answerService.createAnswer(ans);
			return "redirect:/questions/"+q_id;
		}
		
	}

}
