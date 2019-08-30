package com.hcl.parking.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Allocation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int allocationId;
	private int userId;
	private int slotId;
	private LocalDate allotedDate;
}
