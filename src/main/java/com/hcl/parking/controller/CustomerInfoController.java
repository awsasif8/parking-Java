package com.hcl.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.parking.dto.InfoDto;
import com.hcl.parking.service.CustomerInfoService;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = {"*","/"}, origins = {"*","/"})
public class CustomerInfoController {
	@Autowired
	CustomerInfoService customerInfoService;
	@PostMapping("/register")
	public ResponseEntity info(@RequestBody InfoDto infoDto) {
	
		return new ResponseEntity<>(customerInfoService.custInfo(infoDto),HttpStatus.OK);
		
	}

}
