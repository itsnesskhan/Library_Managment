package com.lib.managment.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "borrowed_by_db")
public class BorrowedBy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer borId;

	private Integer sid;
	
	private String student_name;
	
	private Integer bid;
	
	private String book_name;
	
	private LocalDate issueDate;
	
	private LocalDate returnDate;
	
	
}
