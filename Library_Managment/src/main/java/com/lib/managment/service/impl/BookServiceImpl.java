package com.lib.managment.service.impl;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.managment.dtos.BookDto;
import com.lib.managment.models.Books;
import com.lib.managment.repository.BooksRepository;
import com.lib.managment.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BooksRepository booksRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public BookDto addBook(BookDto bookDto) {
		Books book = modelMapper.map(bookDto, Books.class);
		booksRepository.save(book);
		return modelMapper.map(book, bookDto.getClass());
	}

	@Override
	public List<BookDto> getBooks() {
		List<Books> books = booksRepository.findAll();
		return Arrays.asList(modelMapper.map(books, BookDto[].class)) ;
	}

	@Override
	public BookDto getBookById(Integer bid) {
		Books books = booksRepository.findById(bid).orElseThrow(()-> new RuntimeException("no book found with id "+bid));
		return modelMapper.map(books, BookDto.class);
	}

	@Override
	public void deleteBook(Integer bookId) {
		Books books = booksRepository.findById(bookId).orElseThrow(()-> new RuntimeException("no book found with id "+bookId));
		booksRepository.delete(books);
		
	}

	@Override
	public BookDto updateBook(BookDto bookDto) {
		Books books = booksRepository.findById(bookDto.getBook_id()).orElseThrow(()-> new RuntimeException("no book found with id "+bookDto.getBook_id()));
		books.setAuthor(bookDto.getAuthor());
		books.setCategory(bookDto.getCategory());
		books.setPublisher(bookDto.getPublisher());
		books.setPrice(bookDto.getPrice());
		books.setTitle(bookDto.getTitle());
		books = booksRepository.save(books);
		return modelMapper.map(books, BookDto.class);
	}

}
