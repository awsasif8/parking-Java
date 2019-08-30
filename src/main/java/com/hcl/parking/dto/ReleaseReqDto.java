package com.hcl.parking.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReleaseReqDto {
	private int userId;
	private LocalDate fromDate;
	private LocalDate toDate;
	private int slotId;

}
