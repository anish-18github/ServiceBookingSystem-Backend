package com.servicebookingsystem.services.client;

import java.util.List;

import com.servicebookingsystem.dto.AdDTO;
import com.servicebookingsystem.dto.AdDetailsForClientDTO;
import com.servicebookingsystem.dto.ReservationDTO;

public interface ClientService {

	List<AdDTO> getAllAds();
	
	List<AdDTO> searchAdByName(String name);
	
	boolean bookService(ReservationDTO reservationDTO);
	
	 AdDetailsForClientDTO getAdDetailsByAdId(Long adId);
}
