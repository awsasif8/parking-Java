package com.hcl.parking.service;

import com.hcl.parking.dto.ReleaseReqDto;
import com.hcl.parking.dto.ReleaseResDto;

public interface SlotReleaseService {

	ReleaseResDto releaseSlot(ReleaseReqDto releaseReqDto);

}
