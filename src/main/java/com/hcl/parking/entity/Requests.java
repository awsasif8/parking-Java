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
public class Requests {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int requestId;
	private int userId ;
	private LocalDate requestDate;
}
