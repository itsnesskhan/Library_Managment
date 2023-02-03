package com.lib.managment.dtos;

import com.lib.managment.models.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
@NoArgsConstructor
public class PublisherDto {

	private Integer pb_id;
	
	private String fname;
	
	private String lname;
	
	private Address address;

}
