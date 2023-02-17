package com.lib.managment.service;

import java.util.List;

import com.lib.managment.dtos.BookIssueDto;
import com.lib.managment.dtos.BookIssuedResponseDto;
import com.lib.managment.dtos.BookReturnDto;
import com.lib.managment.helper.ApiResponse;

public interface BookIssueService {

	BookIssuedResponseDto issueBook(BookIssueDto bookIssueDto);
	
	ApiResponse returnIssuedBook(BookReturnDto bookReturnDto);
	
	List<BookIssuedResponseDto> getIssuedBookByUserId(Integer uid);
	
}
