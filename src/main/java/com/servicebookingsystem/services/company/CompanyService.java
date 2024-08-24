package com.servicebookingsystem.services.company;

import java.io.IOException;
import java.util.List;

import com.servicebookingsystem.dto.AdDTO;

public interface CompanyService {

	boolean postAd(Long userId, AdDTO adDTO) throws IOException;
	
	List<AdDTO> getAllAds(Long userId);
}
