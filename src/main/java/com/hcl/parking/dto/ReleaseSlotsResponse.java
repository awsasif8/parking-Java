package com.hcl.parking.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReleaseSlotsResponse {

	private String message; 
	private int statusCode;
	private String status;
	private List<ReleaseSlotsDto> data;
	
}
