package com.hcl.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.parking.dto.LoginReqDto;
import com.hcl.parking.dto.LoginResDto;
import com.hcl.parking.service.LoginService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class LoginController {

	@Autowired
	LoginService loginService;

	@PostMapping("/user/login")
	public ResponseEntity<LoginResDto> userLogin(@RequestBody LoginReqDto loginDto) {

		return new ResponseEntity<>(loginService.userLogin(loginDto), HttpStatus.OK);
	}

}
