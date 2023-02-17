package com.lib.managment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lib.managment.models.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
