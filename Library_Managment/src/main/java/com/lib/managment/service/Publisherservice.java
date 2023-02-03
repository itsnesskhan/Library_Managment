package com.lib.managment.service;

import java.util.List;

import com.lib.managment.dtos.CategoryDto;
import com.lib.managment.models.Category;

public interface Publisherservice {

	CategoryDto addCategory(CategoryDto categoryDto);
	
	List<CategoryDto> getCategories();
	
	CategoryDto getCategoryById(Integer id);
	
	CategoryDto updateCategory(CategoryDto categoryDto);
	
	void deleteCategory(Integer id);
	
	
}
