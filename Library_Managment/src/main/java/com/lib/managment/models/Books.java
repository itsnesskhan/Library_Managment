package com.lib.managment.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "Books_Db")
public class Books {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer book_id;
	
	private String title;
	
	private String price;
	
	private String author;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "category_id",referencedColumnName = "cid")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "pb_id", referencedColumnName = "pb_id")
	private Publisher publisher;
	
	
	
}
