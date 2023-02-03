package com.lib.managment.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.lib.managment.dtos.StudentDto;

public interface StudentService {

	StudentDto addStudent(StudentDto studentDto);
	
	List<StudentDto> getAllStudents();
	
	StudentDto getStudentById(Integer sid);
	
	StudentDto getJson(String studentString);
	
	StudentDto updateStudent(StudentDto studentDto, MultipartFile file);
	
}
