package com.example.sbbasic.controller;

import javax.validation.constraints.NotEmpty;

import org.apache.groovy.parser.antlr4.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.sbbasic.service.AnswerService;
import com.example.sbbasic.service.QuestionService;

import lombok.RequiredArgsConstructor;


@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
@Validated
public class AnswerController {

    private final QuestionService questionService;
    
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String createAnswer(@PathVariable("id") Integer id, @RequestParam(value = "content", required = false) String content) {
    	if(StringUtils.isEmpty(content)) {
    		return String.format("redirect:/question/read?id=%s", id);
    	}
    	answerService.create(id, content);
		return String.format("redirect:/question/read?id=%s", id);
    }
}