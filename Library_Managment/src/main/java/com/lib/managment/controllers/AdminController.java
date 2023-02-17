package com.lib.managment.controllers;

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

import com.lib.managment.dtos.AdminDto;
import com.lib.managment.dtos.PublisherDto;
import com.lib.managment.models.Admin;
import com.lib.managment.service.AdminService;
import com.lib.managment.service.Publisherservice;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;

	@PostMapping("/save")
	public ResponseEntity<AdminDto> addAdmin(@RequestBody AdminDto adminDto){
	AdminDto addAdmin = adminService.addAdmin(adminDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(addAdmin);
	}
	
	
}
