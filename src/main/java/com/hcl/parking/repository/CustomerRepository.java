package com.hcl.parking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.parking.entity.*;

public interface CustomerRepository  extends JpaRepository<User,Integer>{

	List<User> findByEmail(String email);

}
