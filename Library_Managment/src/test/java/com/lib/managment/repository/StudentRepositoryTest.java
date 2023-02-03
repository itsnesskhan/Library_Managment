package com.lib.managment.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.lib.managment.models.Address;
import com.lib.managment.models.Student;

@SpringBootTest(classes = StudentRepositoryTest.class)
class StudentRepositoryTest {
	
	@Mock
	private StudentRepository studentRepository;

	//only test your own custom methods
	
	@Test
	void testFindByEmailOrMobileNumber() {
		
		Student student = new Student(101, "Nasser", "Khan", "itsnesskhan@gmail.com", "9713216901", "0", "default.jpg", new Address());
		Optional.of(student);
		
		Mockito.when(studentRepository.findByEmailOrMobileNumber("itsnesskhan@gmail.com", "9713216901")).thenReturn(Optional.of(student));
		assertEquals(Optional.of(student), studentRepository.findByEmailOrMobileNumber("itsnesskhan@gmail.com", "9713216901"));
		
		verify(studentRepository).findByEmailOrMobileNumber("itsnesskhan@gmail.com", "9713216901");
		verify(studentRepository, times(1)).findByEmailOrMobileNumber("itsnesskhan@gmail.com", "9713216901");
	}
	
	@Test
	void testSaveStudent() {
		Student student = new Student(101, "Nasser", "Khan", "itsnesskhan@gmail.com", "9713216901", "0", "default.jpg", new Address());
		
		Mockito.when(studentRepository.save(student)).thenReturn(student);
		
		assertEquals(student, studentRepository.save(student));
		verify(studentRepository).save(student);
	}
	
	

}
