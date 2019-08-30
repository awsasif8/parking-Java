package com.hcl.parking.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.parking.dto.InfoDetails;
import com.hcl.parking.dto.InfoDto;
import com.hcl.parking.entity.User;
import com.hcl.parking.repository.CustomerRepository;



@RunWith(MockitoJUnitRunner.Silent.class)
public class CustomerServiceImplTest {
	@Mock
	CustomerRepository customerRepository;

	
	@InjectMocks
	CustomerInfoServiceImpl customerInfoService;
	@Test
	public void testCustInfo() {
		InfoDto infoDto=new InfoDto();
		infoDto.setEmail("hello");
		InfoDetails n=new InfoDetails();
		n.setStatusCode(200);
		User details=new User();
		details.setEmail("hello");
		
		infoDto.setHclexp(20);
		infoDto.setTotalexp(25);
		List<User> user1=new ArrayList<User>();
		user1.add(details);
		
			details.setEmail(infoDto.getEmail());
			details.setUserName(infoDto.getName());
			details.setPassword(infoDto.getPassword());
			details.setSapId(infoDto.getSapId());
		details.setRole("VIP");
		
		Mockito.when(customerRepository.save(Mockito.anyObject())).thenReturn(details);
	Mockito.when(customerRepository.findByEmail(infoDto.getEmail())).thenReturn(user1);
		InfoDetails det1 = customerInfoService.custInfo(infoDto);
		assertEquals(200,det1.getStatusCode());
	}
	@Test
	public void testCustInfoNegative() {
		InfoDto infoDto=new InfoDto();
		infoDto.setEmail("hello");
		InfoDetails n=new InfoDetails();
		n.setStatusCode(200);
		User user=new User();
		user.setEmail("hello");
		
		List<User> user1=new ArrayList<User>();
		user1.add(user);
	
		Mockito.when(customerRepository.save(Mockito.anyObject())).thenReturn(user);
	Mockito.when(customerRepository.findByEmail(infoDto.getEmail())).thenReturn(user1);
		InfoDetails det1 = customerInfoService.custInfo(infoDto);
		String message="Employee is already registered with this email i'd";
		assertEquals(message,det1.getMessage());
	}
	@Test
	public void testCustInfoPositive() {
		InfoDto infoDto=new InfoDto();
		infoDto.setEmail("hello");
		InfoDetails n=new InfoDetails();
		n.setStatusCode(200);
		User details=new User();
		details.setEmail("hello");
		
		infoDto.setHclexp(0);
		infoDto.setTotalexp(2);
		
	
		
		List<User> user1=new ArrayList<User>();
		user1.add(details);
		
			details.setEmail(infoDto.getEmail());
			details.setUserName(infoDto.getName());
			details.setPassword(infoDto.getPassword());
			details.setSapId(infoDto.getSapId());
		details.setRole("reg");
		
		Mockito.when(customerRepository.save(Mockito.anyObject())).thenReturn(details);
	Mockito.when(customerRepository.findByEmail(infoDto.getEmail())).thenReturn(user1);
		InfoDetails det1 = customerInfoService.custInfo(infoDto);
		assertEquals(200,det1.getStatusCode());
	}
}
