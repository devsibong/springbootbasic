package com.example.sbbasic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sbbasic.domain.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {

}
