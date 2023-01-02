package com.example.sbbasic.service;

import com.example.sbbasic.domain.Question;

public interface AnswerService {
	
	void create(Question question, String content);

}
