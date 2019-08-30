package com.hcl.parking.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hcl.parking.dto.SlotInfoDto;
import com.hcl.parking.service.SlotinfoService;

import junit.framework.TestCase;
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = { TestCase.class, SlotInfoController.class })
@WebAppConfiguration
public class SlotInfoControllerTest {
	@InjectMocks
	private SlotInfoController slotInfoController;
	

	
	@Mock
	private SlotinfoService slotinfoService;

	private MockMvc mockMvc;
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(slotInfoController).build();
	}
	@Test
	public void slotInfoTest() {
		SlotInfoDto an=new SlotInfoDto();
		an.setSlotId(1);
		an.setSapId("51797119");
		an.setStatusCode(200);
		ResponseEntity<SlotInfoDto> expResult = new ResponseEntity<>(an, HttpStatus.OK);
		when(slotinfoService.slotInfo(Mockito.anyInt())).thenReturn(an);
	
		ResponseEntity<SlotInfoDto> actResult = slotInfoController.slotInfo(2);
		assertEquals(expResult, actResult);
		
	}

}
