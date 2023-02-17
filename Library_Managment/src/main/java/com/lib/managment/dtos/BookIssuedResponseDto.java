package com.lib.managment.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookIssuedResponseDto {

	@JsonProperty(namespace = "student_id")
	private Integer sid;
	
	private String student_name;
	
	@JsonProperty(namespace = "book_id")
	private Integer bid;
	
	private String book_name;
	
	private LocalDate issueDate;
	
	private LocalDate returnDate;
}
