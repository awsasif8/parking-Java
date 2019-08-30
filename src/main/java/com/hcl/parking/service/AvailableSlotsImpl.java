package com.hcl.parking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.parking.dto.ReleaseSlotsDto;
import com.hcl.parking.dto.ReleaseSlotsResponse;
import com.hcl.parking.entity.ReleasedSlot;
import com.hcl.parking.entity.Slot;
import com.hcl.parking.exception.ParkingManagementException;
import com.hcl.parking.repository.AvailableRepository;
import com.hcl.parking.repository.AvailableSlotsRepository;

@Service
public class AvailableSlotsImpl implements AvailableSlotsService {

	@Autowired
	AvailableSlotsRepository availableRepository;
	
	@Autowired
	AvailableRepository slotRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(AvailableSlotsImpl.class);
	
	@Override
	public ReleaseSlotsResponse getAvailableSlots(int userId) {
		
		logger.info("event of getAvailable slots in service used");
		
		ReleaseSlotsResponse response = new ReleaseSlotsResponse();
		List<ReleasedSlot> releasedSlot = availableRepository.findAll();
		
		List<ReleaseSlotsDto> slotDto = new ArrayList<>();
		
		for(int i =0;i<releasedSlot.size();i++)
		{
			
			if(releasedSlot.get(i).getSlotStatus().equals("AVAILABLE"))
			{
				Optional<Slot> slot = slotRepository.findById(releasedSlot.get(i).getSlotId());
				if(slot.isPresent())
				{
					ReleaseSlotsDto releaseDto = new ReleaseSlotsDto();
					releaseDto.setSlotId(slot.get().getSlotId());
					releaseDto.setSlotName(slot.get().getSlotName());
					slotDto.add(releaseDto);
				}
			}
			
		}
		
		if(slotDto.isEmpty())
		{
			throw new ParkingManagementException("no slots are present");
		}else {
			response.setMessage("Slots showing");
			response.setStatus("SUCCESS");
			response.setStatusCode(200);
			response.setData(slotDto);
		}
		
		logger.info("event of getAvailable slots in service used and ended");
		
		return response;
	}

}
