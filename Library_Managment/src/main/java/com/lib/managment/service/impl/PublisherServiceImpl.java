package com.lib.managment.service.impl;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.managment.dtos.PublisherDto;
import com.lib.managment.models.Publisher;
import com.lib.managment.repository.PublisherRepository;
import com.lib.managment.service.Publisherservice;

@Service
public class PublisherServiceImpl implements Publisherservice {

	@Autowired
	private PublisherRepository publisherRepository;

	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public PublisherDto addPublisher(PublisherDto publisherDto) {
		
		Publisher publisher = modelMapper.map(publisherDto, Publisher.class);
		publisher = publisherRepository.save(publisher);
		return modelMapper.map(publisher, publisherDto.getClass());
	}

	@Override
	public List<PublisherDto> getPublishers() {
		List<Publisher> all = publisherRepository.findAll();
		return Arrays.asList(modelMapper.map(all, PublisherDto[].class));
	}

	@Override
	public PublisherDto getPublisherById(Integer sid) {
		Publisher publisher = publisherRepository.findById(sid)
				.orElseThrow(() -> new RuntimeException("Publisher does not exist with id " + sid));
		return modelMapper.map(publisher, PublisherDto.class);
	}

	@Override
	public PublisherDto updatePublisher(PublisherDto publisherDto) {
		Publisher publisher = modelMapper.map(publisherDto, Publisher.class);
		publisher = publisherRepository.save(publisher);
		return modelMapper.map(publisher, PublisherDto.class);

	}

	@Override
	public void deletePublisher(Integer id) {
		Publisher publisher = publisherRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Publisher does not exist with id " + id));
		publisherRepository.delete(publisher);
	}


}
