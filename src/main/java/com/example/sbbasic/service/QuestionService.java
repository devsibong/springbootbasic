package com.example.sbbasic.service;

import org.springframework.data.domain.Page;

import com.example.sbbasic.domain.Question;
import com.example.sbbasic.dto.QuestionDTO;

public interface QuestionService {
	void register(QuestionDTO questionDTO);
	
	QuestionDTO readOne(Integer id);
	
//	List<QuestionDTO> getList();
	
	Page<Question> getList(int page);
}
