package com.hcl.parking.service;

import com.hcl.parking.dto.LoginReqDto;
import com.hcl.parking.dto.LoginResDto;

public interface LoginService {

	LoginResDto userLogin(LoginReqDto loginDto);

}
