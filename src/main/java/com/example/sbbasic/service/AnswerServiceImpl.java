package com.example.sbbasic.service;

import org.springframework.stereotype.Service;

import com.example.sbbasic.domain.Answer;
import com.example.sbbasic.domain.Question;
import com.example.sbbasic.repository.AnswerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AnswerServiceImpl implements AnswerService {

	private final AnswerRepository answerRepository;
	
	@Override
	public void create(Question question, String content) {
		Answer answer = Answer.builder()
				.content(content)
				.question(question)
				.build();

        this.answerRepository.save(answer);
	}

}
