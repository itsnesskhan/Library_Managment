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

import com.lib.managment.dtos.PublisherDto;
import com.lib.managment.service.Publisherservice;

@RestController
@RequestMapping("/api/v1/publisher")
public class PublisherController {
	
	@Autowired
	private Publisherservice publisherService;

	@PostMapping("/save")
	public ResponseEntity<PublisherDto> addPublisher(@RequestBody PublisherDto publisherDto){
	PublisherDto publisherResponse = publisherService.addPublisher(publisherDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(publisherResponse);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<PublisherDto>> getAllPublishers(){
		List<PublisherDto> publishers = publisherService.getPublishers();
		return ResponseEntity.status(HttpStatus.OK).body(publishers);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PublisherDto> getcategoryById(@PathVariable Integer id){
		PublisherDto publisherDto = publisherService.getPublisherById(id);
		return ResponseEntity.status(HttpStatus.OK).body(publisherDto);
	}
	
	@PutMapping("/update")
	public ResponseEntity<PublisherDto> updateCategory(@RequestBody PublisherDto publisherDto){
	PublisherDto publisherResponse = publisherService.updatePublisher(publisherDto);
		return ResponseEntity.status(HttpStatus.OK).body(publisherResponse);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletecategoryById(@PathVariable Integer id){
		publisherService.deletePublisher(id);
		return ResponseEntity.status(HttpStatus.OK).body(Map.of("Message","PUBLISHER DELETED SUCCESSFULLY!"));
	}
}
