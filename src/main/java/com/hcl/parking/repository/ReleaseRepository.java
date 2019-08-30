package com.hcl.parking.repository;

import java.util.Optional;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.hcl.parking.entity.ReleasedSlot;
@Repository
public interface ReleaseRepository extends JpaRepository<ReleasedSlot, Integer> {

	Optional<ReleasedSlot> findByUserId(int userId);
	ReleasedSlot findBySlotId(int slotId);

	@Lock(LockModeType.PESSIMISTIC_READ)
	@QueryHints({@QueryHint(name="javax.persistence.lock.timeout", value="3000")})
	ReleasedSlot save(ReleasedSlot slot);

}
