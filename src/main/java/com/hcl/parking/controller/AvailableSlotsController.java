package com.hcl.parking.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.parking.dto.ReleaseSlotsResponse;
import com.hcl.parking.service.AvailableSlotsService;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class AvailableSlotsController {
	
	@Autowired
	AvailableSlotsService availableSlots;
	
	
	private static final Logger logger = LoggerFactory.getLogger(AvailableSlotsController.class);
	
	@GetMapping("/slots/{userId}")
	public ResponseEntity<ReleaseSlotsResponse> getAvailableSeats(@PathVariable("userId") int userId)
	{
		logger.info("entered into getAvailable Slots");
		return new ResponseEntity(availableSlots.getAvailableSlots(userId),HttpStatus.OK);
	}

}
