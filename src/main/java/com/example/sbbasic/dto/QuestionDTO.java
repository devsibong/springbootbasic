package com.example.sbbasic.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.example.sbbasic.domain.Answer;

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
	
	@NotEmpty
	@Size(max=200)
	private String title;
	
	@NotEmpty
	private String content;
	
	private LocalDateTime regDate;
	
	private LocalDateTime modDate;
	
	private List<Answer> answerList;

}
