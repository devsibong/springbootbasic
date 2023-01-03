package com.example.sbbasic.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.sbbasic.domain.Question;
import com.example.sbbasic.dto.QuestionDTO;
import com.example.sbbasic.repository.QuestionRepository;
import com.example.sbbasic.service.QuestionService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {
	
	private final QuestionRepository questionRepository;
	
	private final QuestionService questionService;
	
//	@GetMapping("/list")
//	public void list(Model model) {
//		List<Question> questionList = this.questionRepository.findAll();
//		model.addAttribute("questionList", questionList);
//	}
	
	@GetMapping("/list")
	public void list(Model model) {
		List<QuestionDTO> questionList = questionService.getList();
		model.addAttribute("questionList",questionList);
	}
	
	
//	@GetMapping("/detail/{id}")
//	public String detail(Model model, @PathVariable("id") Integer id) {
//		Question question = this.questionService.getQuestion(id);
//		model.addAttribute("question",question);
//		return "question_detail";		
//	}
	
	@GetMapping("/read")
	public void read(Integer id, Model model) {
		QuestionDTO questionDTO = questionService.readOne(id);
		model.addAttribute("question", questionDTO);
	}
	
	@GetMapping("/register")
	public String registerGet(QuestionDTO questionDTO) {
		return "question_form";
	}
	
	@PostMapping("/register")
	public String registerPost(@Valid QuestionDTO questionDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
		if(bindingResult.hasErrors()) {
//			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
			
			return "question_form";
		}

		this.questionService.register(questionDTO);
		return "redirect:/question/list";
	}
}
