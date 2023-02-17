package com.lib.managment.service.impl;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.managment.dtos.BookIssueDto;
import com.lib.managment.dtos.BookIssuedResponseDto;
import com.lib.managment.dtos.BookResponseDto;
import com.lib.managment.dtos.BookReturnDto;
import com.lib.managment.helper.ApiResponse;
import com.lib.managment.models.Books;
import com.lib.managment.models.IssuedBook;
import com.lib.managment.models.Penalty_Information;
import com.lib.managment.models.Student;
import com.lib.managment.repository.BookIssueRepository;
import com.lib.managment.repository.BooksRepository;
import com.lib.managment.repository.PenaltyRepository;
import com.lib.managment.repository.StudentRepository;
import com.lib.managment.service.BookIssueService;

@Service
public class BookIssueServiceImpl implements BookIssueService {

	@Autowired
	private BookIssueRepository bookIssueRepository;

	@Autowired
	private BooksRepository booksRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PenaltyRepository penaltyRepository;

	@Override
	public BookIssuedResponseDto issueBook(BookIssueDto bookIssueDto) {
		Books book = booksRepository.findById(bookIssueDto.getBook_id())
				.orElseThrow(() -> new RuntimeException("NO book found with id " + bookIssueDto.getBook_id()));
		
		Student student= studentRepository.findById(bookIssueDto.getStudent_id())
				.orElseThrow(() -> new RuntimeException("NO student found with id " + bookIssueDto.getStudent_id()));
		IssuedBook issuedBook = new IssuedBook();
		issuedBook.setBid(book.getBook_id());
		issuedBook.setBook_name(book.getTitle());
		issuedBook.setSid(bookIssueDto.getStudent_id());
		issuedBook.setStudent_name(student.getFname().concat(" ").concat(student.getLname()));
		issuedBook.setIssueDate(LocalDate.now());
		issuedBook.setReturnDate(bookIssueDto.getReturnDate());
		IssuedBook save = bookIssueRepository.save(issuedBook);
		return this.modelMapper.map(save, BookIssuedResponseDto.class);
	}

	@Override
	public ApiResponse returnIssuedBook(BookReturnDto bookReturnDto) {
		Optional<IssuedBook> bookToReturn = bookIssueRepository.findByBookId(bookReturnDto.getBook_id());
		if (!bookToReturn.isPresent()) {
			return new ApiResponse("null","No book found with id "+bookReturnDto.getBook_id());
		}
		long days = ChronoUnit.DAYS.between(bookToReturn.get().getReturnDate(), LocalDate.now());
		
		if (days>=5) {
			
			Penalty_Information penalty_Information = Penalty_Information.builder()
														.book_id(bookToReturn.get().getBid())
														.book_name(bookToReturn.get().getBook_name())
														.student_id(bookToReturn.get().getSid())
														.student_name(bookToReturn.get().getStudent_name())
														.penalty_amount(10* (days/5)).build();
			
			
			penalty_Information = penaltyRepository.save(penalty_Information);
			bookIssueRepository.delete(bookToReturn.get());
			return new ApiResponse(penalty_Information, "Book Returned Successfully!, and you have to pay fine of "+ penalty_Information.getPenalty_amount()+" ruppes !");
		}
		bookIssueRepository.delete(bookToReturn.get());
		
		return new ApiResponse(null, "Book returned Successfully!") ;
	}

	@Override
	public List<BookIssuedResponseDto> getIssuedBookByUserId(Integer uid) {
		List<IssuedBook> issuedBooks = this.bookIssueRepository.findByStudentId(uid);
		System.out.println(issuedBooks);
		List<BookIssuedResponseDto> asList = Arrays.asList(modelMapper.map(issuedBooks, BookIssuedResponseDto[].class));
		return asList;
	}

}
