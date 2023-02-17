package com.lib.managment.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookReturnDto {

	private Integer book_id;
	
	private Integer student_id;
}
