package com.hcl.parking.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hcl.parking.dto.ReleaseSlotsDto;
import com.hcl.parking.dto.ReleaseSlotsResponse;
import com.hcl.parking.service.AvailableSlotsService;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class AvailableSlotsControllerTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	AvailableSlotsController availableController;
	
	@Mock
	AvailableSlotsService availableSlots;
	
	@Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(availableController).build();
    }
	
	
	public ReleaseSlotsDto getReleaseSlots1()
	{
		ReleaseSlotsDto release = new ReleaseSlotsDto();
		release.setSlotId(1);
		release.setSlotName("A1");
		return release;
	}
	
	
	public ReleaseSlotsDto getReleaseSlots2()
	{
		ReleaseSlotsDto release = new ReleaseSlotsDto();
		release.setSlotId(2);
		release.setSlotName("A2");
		return release;
	}
	
	public ReleaseSlotsResponse getReleaseSlotsResponse()
	{
		List<ReleaseSlotsDto> release = new ArrayList<>();
		release.add(getReleaseSlots1());
		release.add(getReleaseSlots2());
		ReleaseSlotsResponse response = new ReleaseSlotsResponse();
		response.setStatus("SUCCESS");
		response.setStatusCode(200);
		response.setMessage("Slots showing");
		response.setData(release);
		return response;
	}
	
	@Test
	public void availableSlotsControllertest()
	{
		ResponseEntity<ReleaseSlotsResponse> expResult = new ResponseEntity<>(getReleaseSlotsResponse(), HttpStatus.OK);
        when(availableSlots.getAvailableSlots(Mockito.anyInt())).thenReturn(getReleaseSlotsResponse());
        ResponseEntity<ReleaseSlotsResponse> actResult = availableController.getAvailableSeats(Mockito.anyInt());
        assertEquals(expResult.getStatusCode(), actResult.getStatusCode());
	}

}
