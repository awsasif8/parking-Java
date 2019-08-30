package com.hcl.parking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.hcl.parking.entity.ReleasedSlot;
@Repository
public interface ReleaseRepository extends JpaRepository<ReleasedSlot, Integer> {

	Optional<ReleasedSlot> findByUserId(int userId);
	ReleasedSlot findBySlotId(int slotId);

}
