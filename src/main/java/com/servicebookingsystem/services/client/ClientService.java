package com.servicebookingsystem.services.client;

import java.util.List;

import com.servicebookingsystem.dto.AdDTO;

public interface ClientService {

	List<AdDTO> getAllAds();
	
	List<AdDTO> searchAdByName(String name);
}
