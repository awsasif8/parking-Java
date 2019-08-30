package com.hcl.parking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.parking.dto.ReleaseSlotsDto;
import com.hcl.parking.dto.ReleaseSlotsResponse;
import com.hcl.parking.entity.ReleasedSlot;
import com.hcl.parking.entity.Slot;
import com.hcl.parking.exception.ParkingManagementException;
import com.hcl.parking.repository.AvailableRepository;
import com.hcl.parking.repository.AvailableSlotsRepository;

@RunWith(MockitoJUnitRunner.class)
public class AvailableSlotsSeriveTest {

	@InjectMocks
	AvailableSlotsImpl availableService;
	
	@Mock
	AvailableSlotsRepository availableRepository;
	
	@Mock
	AvailableRepository slotRepository;
	
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
	
	public ReleasedSlot getReleasedSlot()
	{
		ReleasedSlot releasedSlot = new ReleasedSlot();
		releasedSlot.setReleaseId(1);
		releasedSlot.setSlotStatus("AVAILABLE");
		releasedSlot.setUserId(1);
		return releasedSlot;
	}
	
	
	public ReleasedSlot getReleasedSlot1()
	{
		ReleasedSlot releasedSlot = new ReleasedSlot();
		releasedSlot.setReleaseId(2);
		releasedSlot.setSlotStatus("AVAILABLE");
		releasedSlot.setUserId(2);
		return releasedSlot;
	}
	
	public Slot getSlot()
	{
		Slot slot = new Slot();
		slot.setSlotId(1);
		slot.setSlotName("A1");
		slot.setUserId(1);
		return slot;
	}
	
	@Test
	public void AvailableSlotsTestPositive()
	{
		List<ReleasedSlot> getReleasedSlot = new ArrayList<>();
		getReleasedSlot.add(getReleasedSlot());
		getReleasedSlot.add(getReleasedSlot1());
		Mockito.when(availableRepository.findAll()).thenReturn(getReleasedSlot);
		Mockito.when(slotRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(getSlot()));
		ReleaseSlotsResponse release = availableService.getAvailableSlots(1);
		Assert.assertEquals("SUCCESS", release.getStatus());
	}
	
	
	@Test(expected = ParkingManagementException.class)
	public void AvailableSlotsTestNegative()
	{
		List<ReleasedSlot> getReleasedSlot = new ArrayList<>();
		Mockito.when(availableRepository.findAll()).thenReturn(getReleasedSlot);
	//	Mockito.when(slotRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(getSlot()));
		ReleaseSlotsResponse release = availableService.getAvailableSlots(1);
		Assert.assertEquals("SUCCESS", release.getStatus());
	}
	
	
}
