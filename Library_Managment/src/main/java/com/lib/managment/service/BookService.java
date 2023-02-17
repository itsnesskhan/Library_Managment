package com.lib.managment.service;

import java.util.List;

import com.lib.managment.dtos.BookRequestDto;
import com.lib.managment.dtos.BookResponseDto;

public interface BookService {

	BookRequestDto addBook(BookRequestDto bookDto);
	
	List<BookResponseDto> getBooks();
	
	BookResponseDto getBookById(Integer bid);
	
	BookResponseDto updateBook(BookRequestDto bookDto);
	
	void deleteBook(Integer bookId);
	
}
