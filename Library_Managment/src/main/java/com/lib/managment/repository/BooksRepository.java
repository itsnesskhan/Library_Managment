package com.lib.managment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lib.managment.models.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer> {

}
