package com.lib.managment.dtos;

import com.lib.managment.models.Category;
import com.lib.managment.models.Publisher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDto {

	private Integer book_id;
	
	private String title;
	
	private String price;
	
	private String author;
	
	private Category category;
	
	private Publisher publisher;

}
