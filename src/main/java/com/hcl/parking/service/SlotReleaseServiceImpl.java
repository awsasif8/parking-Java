package com.hcl.parking.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;
import com.hcl.parking.dto.ReleaseReqDto;
import com.hcl.parking.dto.ReleaseResDto;
import com.hcl.parking.entity.ReleasedSlot;
import com.hcl.parking.exception.ParkingManagementException;
import com.hcl.parking.repository.ReleaseRepository;
/***
 * method to release the vip slot
 * @author Pradeep
 *@param  ReleaseReqDto
 *@retun ReleaseResDto
 *@exception ParkingManagementException
 */ 


@Service
public class SlotReleaseServiceImpl implements SlotReleaseService {

	@Autowired
	private ReleaseRepository releaseRepository;

	@Override
	public ReleaseResDto releaseSlot(ReleaseReqDto releaseReqDto) {

		Optional<ReleasedSlot> reSlot = releaseRepository.findByUserId(releaseReqDto.getUserId());
		
		if (!reSlot.isPresent()) {
			ReleasedSlot releaseSlot = new ReleasedSlot();
			BeanUtils.copyProperties(releaseReqDto, releaseSlot);
			releaseSlot.setSlotStatus("AVAILABLE");
			ReleasedSlot result = releaseRepository.save(releaseSlot);
			ReleaseResDto resDto = new ReleaseResDto();
			resDto.setReleaseId(result.getReleaseId());
			resDto.setMessage("Your Parking  Slot is Released Successfully");
			resDto.setStatus("SUCCESS");
			resDto.setStatusCode(HttpStatus.CREATED.value());
			return resDto;

		} else {
			throw new ParkingManagementException("Your Parking  Slot is Already Released");

		}
	}

}
