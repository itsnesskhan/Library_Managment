package com.lib.managment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lib.managment.models.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

}
