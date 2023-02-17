package com.lib.managment.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "role")
public class UserRole {

	@Id
	private Integer rid;
	
	@NonNull
	private String name;
}
