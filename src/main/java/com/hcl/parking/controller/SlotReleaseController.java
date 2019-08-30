package com.hcl.parking.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.parking.dto.ReleaseReqDto;
import com.hcl.parking.dto.ReleaseResDto;
import com.hcl.parking.service.SlotReleaseService;

/***
 * method to release the vip slot
 * @author Pradeep
 *@param  ReleaseReqDto
 *@retun ReleaseResDto
 *
 */

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class SlotReleaseController {
	private static final Logger logger = LoggerFactory.getLogger(SlotReleaseController.class);
	
	@Autowired
	private SlotReleaseService slotReleaseService;
	
	@PostMapping("/releaseslot")
	public ResponseEntity<ReleaseResDto> releaseSlot(@RequestBody ReleaseReqDto releaseReqDto){
		logger.debug("SlotReleaseController releaseSlot()");
		return new ResponseEntity<>(slotReleaseService.releaseSlot(releaseReqDto), HttpStatus.CREATED);
	}
	
	

}
