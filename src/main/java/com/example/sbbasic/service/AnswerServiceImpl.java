package com.example.sbbasic.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.sbbasic.domain.Answer;
import com.example.sbbasic.domain.Question;
import com.example.sbbasic.dto.AnswerDTO;
import com.example.sbbasic.dto.QuestionDTO;
import com.example.sbbasic.repository.AnswerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AnswerServiceImpl implements AnswerService {

	private final ModelMapper modelMapper;
	private final AnswerRepository answerRepository;
	private final QuestionService questionService;
	
//	@Override
//	public void create(Question question, String content) {
//		Answer answer = Answer.builder()
//				.content(content)
//				.question(question)
//				.build();
//
//        this.answerRepository.save(answer);
//	}

	@Override
	public void create(Integer id, String content) {
		Question question = modelMapper.map(questionService.readOne(id), Question.class);
		AnswerDTO answerDTO = AnswerDTO.builder()
				.content(content)
				.question(question)
				.build();
		Answer answer = modelMapper.map(answerDTO, Answer.class);
		
        answerRepository.save(answer);
	}
}
