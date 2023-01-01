package com.example.sbbasic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
	
	@GetMapping("/sbbasic")
	public void index() {
		System.out.println("Hello World");
	}
}
