package com.hcl.parking.service;

import org.springframework.stereotype.Service;

import com.hcl.parking.dto.InfoDetails;
import com.hcl.parking.dto.InfoDto;

@Service
public interface CustomerInfoService {

	InfoDetails custInfo(InfoDto infoDto);

}
