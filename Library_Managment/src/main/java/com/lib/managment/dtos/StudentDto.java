package com.lib.managment.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

	private Integer sid;
	
	private String fname;
	
	private String lname;
	
	private String email;
	
	private String mobile;
	
	private String profile;
	
	private String bookIssuedCount;
	
	private AddressDto address;
	
	
}
