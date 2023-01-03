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
	
	@NotEmpty(message="제목은 필수 항목입니다.")
	@Size(max=200)
	private String title;
	
	@NotEmpty(message="내용은 필수 항목입니다.")
	private String content;
	
	private LocalDateTime regDate;
	
	private LocalDateTime modDate;
	
	private List<Answer> answerList;

}
