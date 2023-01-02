package com.example.sbbasic.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {
	
	private int id;
	
	private String title;
	
	private String content;
	
	private LocalDateTime regDate;
	
	private LocalDateTime modDate;

}
