package com.lib.managment.controllers;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lib.managment.dtos.BookRequestDto;
import com.lib.managment.dtos.BookResponseDto;
import com.lib.managment.service.BookService;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
	
	@Autowired
	private BookService bookService;

	@PostMapping("/save")
	public ResponseEntity<BookRequestDto> addBook(@RequestBody BookRequestDto bookDto){
		BookRequestDto Book = bookService.addBook(bookDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(Book);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<BookResponseDto>> getBooks(){
		List<BookResponseDto> Book = bookService.getBooks();
		return ResponseEntity.status(HttpStatus.OK).body(Book);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BookResponseDto> getBookById(@PathVariable Integer id){
		BookResponseDto Book = bookService.getBookById(id);
		return ResponseEntity.status(HttpStatus.OK).body(Book);
	}
	
	@PutMapping("/update")
	public ResponseEntity<BookResponseDto> updateBook(@RequestBody BookRequestDto bookDto){
		BookResponseDto Book = bookService.updateBook(bookDto);
		return ResponseEntity.status(HttpStatus.OK).body(Book);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteBookById(@PathVariable Integer id){
		bookService.deleteBook(id);
		return ResponseEntity.status(HttpStatus.OK).body(Map.of("Message","BOOK DELETED SUCCESSFULLY!"));
	}
	
	public static void main(String[] args) {
//		long days = Duration.between(LocalDate.of(1998, 10, 15), LocalDate.now()).toDays();
//		System.out.println(days); will alway throw error
		
		long days = ChronoUnit.DAYS.between(LocalDate.of(2022, 11, 1), LocalDate.now());
		System.out.println(days);
	}
}
