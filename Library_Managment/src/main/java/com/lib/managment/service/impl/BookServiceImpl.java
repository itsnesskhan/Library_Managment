package com.lib.managment.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.managment.dtos.BookRequestDto;
import com.lib.managment.dtos.BookResponseDto;
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
	public BookRequestDto addBook(BookRequestDto bookDto) {
		Books book = modelMapper.map(bookDto, Books.class);
		booksRepository.save(book);
		return modelMapper.map(book, bookDto.getClass());
	}

	@Override
	public List<BookResponseDto> getBooks() {
		List<Books> books = booksRepository.findAll();
		List<BookResponseDto> bookResponse = books.stream().map(book-> bookToBookResponse(book)).collect(Collectors.toList());
		return bookResponse ;
	}

	@Override
	public BookResponseDto getBookById(Integer bid) {
		Books books = booksRepository.findById(bid).orElseThrow(()-> new RuntimeException("no book found with id "+bid));
		return this.bookToBookResponse(books);
	}

	@Override
	public void deleteBook(Integer bookId) {
		Books books = booksRepository.findById(bookId).orElseThrow(()-> new RuntimeException("no book found with id "+bookId));
		booksRepository.delete(books);
		
	}

	@Override
	public BookResponseDto updateBook(BookRequestDto bookRequestDto) {
		Books books = booksRepository.findById(bookRequestDto.getBook_id()).orElseThrow(()-> new RuntimeException("no book found with id "+bookRequestDto.getBook_id()));
		Books bookDto = modelMapper.map(bookRequestDto, Books.class);
		books.setAuthor(bookDto.getAuthor());
		books.setCategory(bookDto.getCategory());
		books.setPublisher(bookDto.getPublisher());
		books.setPrice(bookDto.getPrice());
		books.setTitle(bookDto.getTitle());
		books = booksRepository.save(books);
		return bookToBookResponse(books);
	}
	
	private BookResponseDto bookToBookResponse(Books books) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		TypeMap<Books, BookResponseDto> typeMap = modelMapper.typeMap(Books.class, BookResponseDto.class);
		typeMap.addMappings(modelMapper-> modelMapper.map(src-> src.getCategory().getName(), BookResponseDto::setCategory));
		typeMap.addMappings(modelMapper-> modelMapper.map(src-> src.getPublisher().getFullName(), BookResponseDto::setPublisher));
		BookResponseDto responseDto = modelMapper.map(books, BookResponseDto.class);
		return responseDto;
	}

}
