package com.lib.managment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lib.managment.models.Penalty_Information;

@Repository
public interface PenaltyRepository extends JpaRepository<Penalty_Information, Integer> {

}
