package com.lib.managment.service.impl;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.managment.dtos.CategoryDto;
import com.lib.managment.models.Category;
import com.lib.managment.repository.CategoryRepository;
import com.lib.managment.service.CatgoryService;

@Service
public class CategoryServiceImpl implements CatgoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto addCategory(CategoryDto CategoryDto) {
		Category category = modelMapper.map(CategoryDto, Category.class);
		category = categoryRepository.save(category);
		return modelMapper.map(category, CategoryDto.getClass());
	}

	@Override
	public List<CategoryDto> getCategories() {
		List<Category> categories = categoryRepository.findAll();
		return Arrays.asList(modelMapper.map(categories, CategoryDto[].class));
	}

	@Override
	public CategoryDto getCategoryById(Integer cid) {
		Category category = categoryRepository.findById(cid)
				.orElseThrow(() -> new RuntimeException("no category found with id " + cid));
		return modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer cId) {
		Category category = categoryRepository.findById(cId)
				.orElseThrow(() -> new RuntimeException("no category found with id " + cId));
		categoryRepository.delete(category);

	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto) {
		Category category = categoryRepository.findById(categoryDto.getCid())
				.orElseThrow(() -> new RuntimeException("no category found with id " + categoryDto.getCid()));
		category = modelMapper.map(categoryDto, Category.class);
		category = categoryRepository.save(category);
		return modelMapper.map(category, CategoryDto.class);
	}

}
