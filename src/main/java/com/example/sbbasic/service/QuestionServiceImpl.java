package com.example.sbbasic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.sbbasic.domain.Question;
import com.example.sbbasic.dto.QuestionDTO;
import com.example.sbbasic.repository.QuestionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class QuestionServiceImpl implements QuestionService{
	
	private final ModelMapper modelMapper;
	
	private final QuestionRepository questionRepository;
	
	@Override
	public void register(QuestionDTO questionDTO) {
		
		Question question = modelMapper.map(questionDTO, Question.class);
		
		questionRepository.save(question);
		
	}
	
	@Override
	public QuestionDTO readOne(Integer id) {
		Optional<Question> result = questionRepository.findById(id);
		
		Question question = result.orElseThrow();
		
		QuestionDTO questionDTO = modelMapper.map(question, QuestionDTO.class);
		
		return questionDTO;
				
	}

//	@Override
//	public List<QuestionDTO> getList() {
//		List<QuestionDTO> result = questionRepository.findAll().stream()
//					.map(question -> modelMapper.map(question, QuestionDTO.class))
//					.collect(Collectors.toList());
//		
//		
//		
//		return result;
//	}

	@Override
	public Page<Question> getList(int page) {
		List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("regDate"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return this.questionRepository.findAll(pageable);
    }


}
