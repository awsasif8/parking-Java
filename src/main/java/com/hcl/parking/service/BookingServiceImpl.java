package com.hcl.parking.service;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.parking.dto.BookingReqDTO;
import com.hcl.parking.dto.BookingResDTO;
import com.hcl.parking.entity.Allocation;
import com.hcl.parking.entity.ReleasedSlot;
import com.hcl.parking.entity.User;
import com.hcl.parking.exception.ParkingManagementException;
import com.hcl.parking.repository.AllocationRepository;
import com.hcl.parking.repository.ReleaseRepository;
import com.hcl.parking.repository.UserRepository;
import com.hcl.parking.util.MailApi;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	AllocationRepository allocRepo;

	@Autowired
	MailApi mailApi;

	@Autowired
	UserRepository userRepo;

	@Autowired
	ReleaseRepository relRepo;

	@Autowired
	private EntityManagerFactory emf;

	@Override
	/**
	 * method to book the slot for user
	 * 
	 * @Param bookingReqDTO
	 * @return bookingResDTO
	 * @exception ParkingManagementException
	 */
	public BookingResDTO bookSlot(BookingReqDTO bookingReqDTO) {

		Allocation allocation = allocRepo.findBySlotId(bookingReqDTO.getSlotId());
		EntityManager em = emf.createEntityManager();
	
		if (null != allocation)
			throw new ParkingManagementException("Parking slot already allocated");

		try {
			em.getTransaction().begin();
			allocation = new Allocation();
			allocation.setAllotedDate(LocalDate.now());
			allocation.setSlotId(bookingReqDTO.getSlotId());
			allocation.setUserId(bookingReqDTO.getUserId());
			allocation = allocRepo.save(allocation);

			ReleasedSlot relSlot = relRepo.findBySlotId(bookingReqDTO.getSlotId());
			relSlot.setSlotStatus("BOOKED");
			relSlot = relRepo.save(relSlot);

			BookingResDTO bookingResDTO = new BookingResDTO();
			bookingResDTO.setAllocationId(allocation.getAllocationId());
			bookingResDTO.setMessage("Booking successful");
			bookingResDTO.setStatus("SUCCESS");
			bookingResDTO.setStatusCode(200);

			User user = userRepo.findById(bookingReqDTO.getUserId()).get();
			mailApi.sendMail(user.getEmail(), bookingReqDTO.getSlotId());
			em.getTransaction().commit();
			return bookingResDTO;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new ParkingManagementException("Error in allocating parking slot!! PLease try later");
		}
	}
}
