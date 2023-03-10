package com.lib.managment.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;
import com.lib.managment.dtos.AddressDto;
import com.lib.managment.dtos.StudentDto;
import com.lib.managment.helper.RoleEnum;
import com.lib.managment.models.Address;
import com.lib.managment.models.Student;
import com.lib.managment.models.UserRole;
import com.lib.managment.repository.StudentRepository;
import com.lib.managment.service.impl.StudentServiceImpl;

@SpringBootTest(classes = StudentServiceTest.class)
class StudentServiceTest {

	@Mock
	StudentRepository studentRepository;

	@Mock
	ModelMapper modelMapper;

	@InjectMocks
	StudentService studentService = new StudentServiceImpl();

	@Test
	void testAddStudent() {
		StudentDto studentDto = new StudentDto(101, "Nasser", "Khan", "itsnesskhan@gmail.com", "9713216901", "default.jpg",
				"0", new AddressDto());
		
		Student student = new Student(101, "Nasser", "Khan", "itsnesskhan@gmail.com", "9713216901", "0", "default.jpg",new UserRole(RoleEnum.STUDENT.getRole()), new Address());

		// this is not calling
		Mockito.when(studentRepository.save(student)).thenReturn(student);
		Mockito.when(modelMapper.map(studentDto,Student.class)).thenReturn(student);
		Mockito.when(modelMapper.map(student,StudentDto.class)).thenReturn(studentDto);
		
		Mockito.when(studentRepository.findByEmailOrMobileNumber(student.getEmail(),student.getMobile())).thenReturn(Optional.empty());
		// here you can see only got called once
		StudentDto studentResponse = studentService.addStudent(studentDto);
//		System.out.println(studentResponse);

		assertEquals(studentDto.getFname(), studentResponse.getFname());
		assertEquals(studentDto.getLname(), studentResponse.getLname());
		assertEquals(studentDto.getEmail(), studentResponse.getEmail());
		assertEquals(studentDto.getMobile(), studentResponse.getMobile());

		// want to verify that save method in repository method get called or not

		verify(studentRepository).save(student); // verify add student get called with student object or not

//		verify(studentService).addStudent(student); will throw exception, cause not a mock verify it got called only once, as you can see above
//		verify(studentService, times(1)).addStudent(student); // verify it got called only once, as you can see above
		// only got called once

	}

	@Test
	@Disabled
	void testGetAllStudents() {
		fail("Not yet implemented");
	}

}
