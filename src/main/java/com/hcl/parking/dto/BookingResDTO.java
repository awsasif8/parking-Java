package com.hcl.parking.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookingResDTO {

	private String message;
	private String status;
	private int statusCode;
	private int allocationId;
	
}
