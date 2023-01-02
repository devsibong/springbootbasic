package com.example.sbbasic.service;

import java.util.List;

import com.example.sbbasic.domain.Question;
import com.example.sbbasic.dto.QuestionDTO;

public interface QuestionService {
	int register(QuestionDTO questionDTO);
	
	QuestionDTO readOne(Integer id);
	
	List<Question> getList();
	
	Question getQuestion(Integer id);
	
	void create(String title, String content);
}
