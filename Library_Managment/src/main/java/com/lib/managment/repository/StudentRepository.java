package com.lib.managment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lib.managment.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query(value = "SELECT * FROM library_managment.student_db WHERE email =:email Or mobile_number =:mobile", nativeQuery = true)
	Optional<Student> findByEmailOrMobileNumber(@Param("email") String email, @Param("mobile") String mobile);
}
