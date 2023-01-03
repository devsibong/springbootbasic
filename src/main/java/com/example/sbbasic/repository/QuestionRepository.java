package com.example.sbbasic.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sbbasic.domain.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
	Page<Question> findAll(Pageable pageable);
}
