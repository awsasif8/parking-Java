package com.hcl.parking.service;

import org.springframework.stereotype.Service;

import com.hcl.parking.dto.ReleaseSlotsResponse;

@Service
public interface AvailableSlotsService {

	public ReleaseSlotsResponse getAvailableSlots(int userId);
	
}
