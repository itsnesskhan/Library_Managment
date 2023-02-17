package com.lib.managment.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookIssueDto {

	private Integer book_id;
	
	private Integer student_id;
	
	private LocalDate returnDate;
}
