package com.hcl.parking.service;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.hcl.parking.dto.SlotInfoDto;
import com.hcl.parking.entity.Slot;
import com.hcl.parking.entity.User;
import com.hcl.parking.repository.SlotRepository;
import com.hcl.parking.repository.UserRepository;


@RunWith(MockitoJUnitRunner.class)
public class SlotinfoServiceImplTest {


	@Mock
	private UserRepository userRepository;
	@Mock
	private SlotRepository slotRepository;
	
	@InjectMocks
	private SlotinfoServiceImpl slotinfoServiceImpl;
	@Test
	public void slotInfoTest() {
		SlotInfoDto expResult=new SlotInfoDto();
		expResult.setStatusCode(HttpStatus.OK.value());
		User user=new User();
		user.setUserId(1);
		Slot slot=new Slot();
		slot.setSlotId(1);
		Mockito.when(userRepository.findByUserId(1)).thenReturn(user);
		Mockito.when(slotRepository.findByUserId(1)).thenReturn(Optional.of(slot));
		SlotInfoDto actResult=slotinfoServiceImpl.slotInfo(1);
		assertEquals(expResult.getStatusCode(), actResult.getStatusCode());
	}

}
