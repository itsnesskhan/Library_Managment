package com.lib.managment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lib.managment.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
