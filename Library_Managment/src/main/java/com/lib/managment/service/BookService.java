package com.lib.managment.service;

import java.util.List;

import com.lib.managment.dtos.BookDto;

public interface BookService {

	BookDto addBook(BookDto bookDto);
	
	List<BookDto> getBooks();
	
	BookDto getBookById(Integer bid);
	
	BookDto updateBook(BookDto bookDto);
	
	void deleteBook(Integer bookId);
	
}