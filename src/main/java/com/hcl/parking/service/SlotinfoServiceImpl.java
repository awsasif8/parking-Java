package com.hcl.parking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.parking.dto.SlotInfoDto;
import com.hcl.parking.entity.Slot;
import com.hcl.parking.entity.User;

import com.hcl.parking.exception.UserNotFound;
import com.hcl.parking.repository.SlotRepository;
import com.hcl.parking.repository.UserRepository;

/***
 * 
 * @author Pradeep method to return the slot info
 *
 * @param userId
 * @retun ReleaseResDto
 * @exception ParkingManagementException
 */

@Service
public class SlotinfoServiceImpl implements SlotinfoService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SlotRepository slotRepository;

	@Override
	public SlotInfoDto slotInfo(Integer userId) {
		User user = userRepository.findByUserId(userId);
		Optional<Slot> slot = slotRepository.findByUserId(userId);
		if (slot.isPresent()) {
			Slot slott = slot.get();
			SlotInfoDto resDto = new SlotInfoDto();
			resDto.setSapId(user.getSapId());
			resDto.setSlotId(slott.getSlotId());
			resDto.setSlotName(slott.getSlotName());
			resDto.setUserName(user.getUserName());
			resDto.setStatus("SUCCESS");
			resDto.setStatusCode(HttpStatus.OK.value());
			resDto.setMessage("User Infomation");
			return resDto;
		} else {
			throw new UserNotFound("Can't Find Slot Information ");
		}

	}

}
