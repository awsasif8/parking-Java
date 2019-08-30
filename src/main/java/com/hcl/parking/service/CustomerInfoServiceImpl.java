package com.hcl.parking.service;




import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.parking.dto.InfoDetails;
import com.hcl.parking.dto.InfoDto;
import com.hcl.parking.entity.Slot;
import com.hcl.parking.entity.User;
import com.hcl.parking.repository.CustomerRepository;
import com.hcl.parking.repository.SlotRepository;


@Service
public class CustomerInfoServiceImpl implements CustomerInfoService  {

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	SlotRepository slotRepository;

	@Override
	public InfoDetails custInfo(InfoDto infoDto) {

	User details = new User();
	List<User> user=customerRepository.findByEmail(infoDto.getEmail());
if(user.isEmpty())
{
	
	if(infoDto.getTotalexp()>=15&&infoDto.getHclexp()>=5) {
		details.setEmail(infoDto.getEmail());
		details.setUserName(infoDto.getName());
		details.setPassword(infoDto.getPassword());
		details.setSapId(infoDto.getSapId());
		details.setRole("vip");
	}
	else
	{
		details.setEmail(infoDto.getEmail());
		details.setUserName(infoDto.getName());
		details.setPassword(infoDto.getPassword());
		details.setSapId(infoDto.getSapId());
		details.setRole("reg");
	}

		customerRepository.save(details);

Slot slots=new Slot();

Integer num = details.getUserId()+1;
String message="A";
String h=message.concat(num.toString());
slots.setSlotName(h);
slots.setUserId(details.getUserId());
slotRepository.save(slots);
	
	InfoDetails det=new InfoDetails();
	
		det.setMessage("user Registered successfully");
	
		det.setStatusCode(200);
		det.setStatus("SUCCESS");
		return det;

	}
	
	else {

		InfoDetails det=new InfoDetails();
		
			det.setMessage("Employee is already registered with this email i'd");
			det.setStatusCode(200);
			det.setStatus("FAILURE");
			return det;

	}
}
}
