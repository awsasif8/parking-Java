package com.hcl.parking.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.parking.dto.LoginReqDto;
import com.hcl.parking.dto.LoginResDto;
import com.hcl.parking.entity.User;
import com.hcl.parking.repository.UserRepository;
@RunWith(MockitoJUnitRunner.class)
public class LoginServiceImplTest {

	@Mock
	UserRepository userRepository;

	
	@InjectMocks
	LoginServiceImpl userLoginService;
	
	@Test
	public void Logintest() {
		LoginReqDto req=new LoginReqDto();
		req.setEmail("pradeep.aj28@gmail.com");
		req.setPassword("qwerty");
		LoginResDto res=new LoginResDto();
		res.setMessage("succes");
		res.setStatusCode(200);
		User ud=new User();
		ud.setEmail("pradeep.aj28@gmail.com");
		ud.setPassword("qwerty");
		ud.setUserId(1);
		Mockito.when(userRepository.findByEmailAndPassword(req.getEmail(),req.getPassword())).thenReturn(ud);
		LoginResDto actualValue = userLoginService.userLogin(req);
		assertEquals(200, actualValue.getStatusCode());
		
	}

}
