package com.lib.managment.controllers;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lib.managment.dtos.StudentDto;
import com.lib.managment.dtos.VarifyOtpRequest;
import com.lib.managment.helper.ApiResponse;
import com.lib.managment.service.StudentService;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/register")
	public ResponseEntity<ApiResponse> registerStudent(@RequestBody StudentDto studentDto){
		 boolean emailVarification = studentService.registerStudentWithEmailVarification(studentDto);
		 if (emailVarification) {
			return ResponseEntity.ok(new ApiResponse(null, "OTP send successfully!"));
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(null, "Please enter a valid email address"));
	}
	
	@PostMapping("/save")
	public ResponseEntity<StudentDto> addStudent(@RequestBody StudentDto studentDto){
		StudentDto student = studentService.addStudent(studentDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(student);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<StudentDto	>> getStudents(){
		List<StudentDto> students = studentService.getAllStudents();
		return ResponseEntity.status(HttpStatus.OK).body(students);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StudentDto> getStudentById(@PathVariable Integer id){
		StudentDto student = studentService.getStudentById(id);
		return ResponseEntity.status(HttpStatus.OK).body(student);
	}
	
	@PostMapping("/varify")
	public ResponseEntity<ApiResponse> varifyOtp(@RequestBody VarifyOtpRequest varifyOtpRequest ){
		ApiResponse varifyOtp = studentService.varifyOtp(varifyOtpRequest);
		return ResponseEntity.status(HttpStatus.OK).body(varifyOtp);
	}
	
	@PutMapping(path = "/update" ,consumes = {org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<?> updateStudent(@RequestParam("user") String userString,
			@RequestPart(name = "profile", required = false) Optional<MultipartFile> file) {
		StudentDto studentDto = studentService.getJson(userString);
		StudentDto updateStudent = studentService.updateStudent(studentDto, file.get());
		return ResponseEntity.ok(updateStudent);
	}
	

}
