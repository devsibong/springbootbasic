package com.example.sbbasic.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.sbbasic.domain.Question;
import com.example.sbbasic.dto.QuestionDTO;
import com.example.sbbasic.exception.DataNotFoundException;
import com.example.sbbasic.repository.QuestionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class QuestionServiceImpl implements QuestionService{
	
	private final ModelMapper modelMapper;
	
	private final QuestionRepository questionRepository;
	
	@Override
	public int register(QuestionDTO questionDTO) {
		
		Question question = modelMapper.map(questionDTO, Question.class);
		
		int id = questionRepository.save(question).getId();
		
		return id;
	}
	
	@Override
	public QuestionDTO readOne(Integer id) {
		Optional<Question> result = questionRepository.findById(id);
		
		Question question = result.orElseThrow();
		
		QuestionDTO questionDTO = modelMapper.map(question, QuestionDTO.class);
		
		return questionDTO;
				
	}

	@Override
	public List<Question> getList() {
		return this.questionRepository.findAll();
	}

	@Override
	public Question getQuestion(Integer id) {
		Optional<Question> question = this.questionRepository.findById(id);
		if(question.isPresent()) {
			return question.get();
		} else {
			throw new DataNotFoundException("question not found");
		}
	}

	@Override
	public void create(String title, String content) {
		Question question = Question.builder()
					.title(title)
					.content(content)
					.build();
		this.questionRepository.save(question);
		
	}

}
