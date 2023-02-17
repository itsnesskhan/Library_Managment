package com.lib.managment.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookRequestDto {

	private Integer book_id;
	
	private String title;
	
	private String price;
	
	private String author;
	
	private CategoryDto category;
	
	private PublisherDto publisher;

}
