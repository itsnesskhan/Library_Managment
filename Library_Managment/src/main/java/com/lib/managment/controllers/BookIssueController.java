package com.lib.managment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lib.managment.dtos.BookIssueDto;
import com.lib.managment.dtos.BookIssuedResponseDto;
import com.lib.managment.dtos.BookResponseDto;
import com.lib.managment.dtos.BookReturnDto;
import com.lib.managment.helper.ApiResponse;
import com.lib.managment.service.BookIssueService;

@RestController
@RequestMapping("/issueBook")
public class BookIssueController {
	
	@Autowired
	private BookIssueService bookIssueService;
	
	@PostMapping
	public ResponseEntity<BookIssuedResponseDto> issueBook(@RequestBody BookIssueDto bookIssueDto){
		BookIssuedResponseDto issueBook = bookIssueService.issueBook(bookIssueDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(issueBook);
	}
	
	@PostMapping("/return")
	public ResponseEntity<ApiResponse> returnBook(@RequestBody BookReturnDto bookReturnDto){
		ApiResponse issueBook = bookIssueService.returnIssuedBook(bookReturnDto);
		return ResponseEntity.status(HttpStatus.OK).body(issueBook);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<List<BookIssuedResponseDto>> GetBookByStudent(@PathVariable Integer id){
		List<BookIssuedResponseDto> issueBook = bookIssueService.getIssuedBookByUserId(id);
		return ResponseEntity.status(HttpStatus.OK).body(issueBook);
	}
}
