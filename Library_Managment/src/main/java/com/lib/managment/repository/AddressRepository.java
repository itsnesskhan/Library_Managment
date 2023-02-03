package com.lib.managment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lib.managment.models.Address;

public interface AddressRepository extends JpaRepository<Address,Integer> {

}
