package com.hcl.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.parking.dto.BookingReqDTO;
import com.hcl.parking.dto.BookingResDTO;
import com.hcl.parking.service.BookingService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@PostMapping("/book")
	public ResponseEntity<BookingResDTO> bookSlot(@RequestBody BookingReqDTO bookingReqDTO){
		return new ResponseEntity<>(bookingService.bookSlot(bookingReqDTO), HttpStatus.OK);
	}

}
