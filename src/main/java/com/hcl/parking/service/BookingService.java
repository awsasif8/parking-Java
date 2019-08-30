package com.hcl.parking.service;

import com.hcl.parking.dto.BookingReqDTO;
import com.hcl.parking.dto.BookingResDTO;

public interface BookingService {

	BookingResDTO bookSlot(BookingReqDTO bookingReqDTO);

}
