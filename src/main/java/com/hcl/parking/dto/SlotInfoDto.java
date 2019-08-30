package com.hcl.parking.dto;

import lombok.Setter;

import lombok.Getter;

@Getter
@Setter
public class SlotInfoDto {
	private String message;
	private int statusCode;
	private String status;
	private int slotId;
	private String slotName;
	private String userName;
	private String sapId;
}
