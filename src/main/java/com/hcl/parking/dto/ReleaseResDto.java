package com.hcl.parking.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReleaseResDto {
	private String message;
	private int statusCode;
	private String status;
	private int releaseId;

}
