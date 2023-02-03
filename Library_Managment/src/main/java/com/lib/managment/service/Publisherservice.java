package com.lib.managment.service;

import java.util.List;

import com.lib.managment.dtos.PublisherDto;

public interface Publisherservice {

	PublisherDto addPublisher(PublisherDto PublisherDto);
	
	List<PublisherDto> getPublishers();
	
	PublisherDto getPublisherById(Integer id);
	
	PublisherDto updatePublisher(PublisherDto PublisherDto);
	
	void deletePublisher(Integer id);
	
}
