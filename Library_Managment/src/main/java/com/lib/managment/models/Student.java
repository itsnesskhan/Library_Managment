package com.lib.managment.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_db",uniqueConstraints = {@UniqueConstraint(columnNames = {"email","mobile_number"})})
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sid;
	
	@Column(name = "first_name")
	private String fname;
	
	@Column(name = "last_name")
	private String lname;
	
	private String email;
	
	@Column(name = "mobile_number")
	private String mobile;
	
	private String bookIssuedCount;
	
	private String profile="default.jpg";
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "role_id", referencedColumnName = "rid", nullable = false)
	private UserRole role;
	
	@OneToOne(fetch = FetchType.EAGER ,cascade = CascadeType.MERGE)
	@JoinColumn(name = "address_id",referencedColumnName = "address_id", nullable = false)
	private Address address;
	
	
	
}
