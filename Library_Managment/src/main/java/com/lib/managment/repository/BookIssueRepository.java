package com.lib.managment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lib.managment.models.IssuedBook;

@Repository
public interface BookIssueRepository extends JpaRepository<IssuedBook, Integer> {

	@Query(value = "SELECT * FROM issued_book_db WHERE sid= :id", nativeQuery = true)
	List<IssuedBook> findByStudentId(@Param("id") Integer id);
	
	@Query(value = "SELECT * FROM issued_book_db WHERE bid= :id", nativeQuery = true)
	Optional<IssuedBook> findByBookId(@Param("id") Integer id);
}
