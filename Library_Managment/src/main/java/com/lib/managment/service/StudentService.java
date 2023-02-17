package com.lib.managment.service;

import java.util.List;
import java.util.Map;

import javax.print.DocFlavor.STRING;

import org.springframework.web.multipart.MultipartFile;

import com.lib.managment.dtos.StudentDto;
import com.lib.managment.dtos.VarifyOtpRequest;
import com.lib.managment.helper.ApiResponse;

public interface StudentService {

	StudentDto addStudent(StudentDto studentDto);
	
	List<StudentDto> getAllStudents();
	
	StudentDto getStudentById(Integer sid);
	
	StudentDto getJson(String studentString);
	
	StudentDto updateStudent(StudentDto studentDto, MultipartFile file);
	
	boolean registerStudentWithEmailVarification(StudentDto studentDto);
	
	ApiResponse varifyOtp(VarifyOtpRequest varifyOtpRequest);
	
}
