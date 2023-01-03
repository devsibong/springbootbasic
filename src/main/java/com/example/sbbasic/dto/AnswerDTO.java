package com.example.sbbasic.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import com.example.sbbasic.domain.Question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDTO {
	
	private int id;
	
	@NotEmpty
	private String content;
	
	private Question question;

	private LocalDateTime regDate;
	
	private LocalDateTime modDate;
}
