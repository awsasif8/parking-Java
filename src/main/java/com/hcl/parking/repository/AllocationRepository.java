package com.hcl.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.parking.entity.Allocation;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Integer>{

	Allocation findBySlotId(int slotId);

}
