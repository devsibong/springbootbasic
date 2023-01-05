package com.example.sbbasic;

import java.util.Optional;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.sbbasic.domain.Question;
import com.example.sbbasic.dto.QuestionDTO;
import com.example.sbbasic.repository.QuestionRepository;
import com.example.sbbasic.service.QuestionService;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class CRUDTest {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private QuestionService questionService;
	
	void testJpa() {
		IntStream.rangeClosed(1, 100).forEach(i -> {
		Question question = Question.builder()
				.title("테스트 제목입니다..." +i)
				.content("테스트 본문입니다...."+i)
				.build();

		
		
		Question result = questionRepository.save(question);
		log.info("ID: " + result.getId());
		});
	}
	@Transactional
	void testSelect() {
		int id = 10;
		Optional<Question> result = questionRepository.findById(id);
		Question question = result.orElseThrow();
		log.info(question);
	}
	
	@Transactional
	void testRegister() {
		QuestionDTO questionDTO = QuestionDTO.builder()
					.title("Sample Title......")
					.content("Sample Content........")
					.build();
		
	}
	
	@Transactional
	void testUpdate() {
		int id = 50;
		
		Optional<Question> result = questionRepository.findById(id);
		
		Question question = result.orElseThrow();
		
		question.change("update title......", "update content.......");
		
		questionRepository.save(question);
	}

	@Transactional
	void testDelete() {
		int id = 30;
		
		questionRepository.deleteById(id);
		
		
	}
}
