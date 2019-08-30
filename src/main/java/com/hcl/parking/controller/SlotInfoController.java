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

import com.hcl.parking.dto.SlotInfoDto;
import com.hcl.parking.service.SlotinfoService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class SlotInfoController {
	private static final Logger logger = LoggerFactory.getLogger(SlotInfoController.class);
	
	@Autowired
	private SlotinfoService slotinfoService;
	
	@GetMapping("/userslot/{userId}")
	public ResponseEntity<SlotInfoDto> slotInfo(@PathVariable Integer userId ){
		logger.debug("SlotInfoController slotInfo()");
		return new ResponseEntity<>(slotinfoService.slotInfo(userId),HttpStatus.OK);
	}

}
