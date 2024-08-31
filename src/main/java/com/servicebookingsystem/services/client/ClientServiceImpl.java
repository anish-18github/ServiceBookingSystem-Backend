package com.servicebookingsystem.services.client;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicebookingsystem.dto.AdDTO;
import com.servicebookingsystem.entity.Ad;
import com.servicebookingsystem.repository.AdRepository;

@Service
public class ClientServiceImpl implements ClientService{

	@Autowired
	private AdRepository adRepository;
	
	public List<AdDTO> getAllAds(){
		return adRepository.findAll().stream().map(Ad::getAdDto).collect(Collectors.toList());
	}
	
	public List<AdDTO> searchAdByName(String name){
		return adRepository.findAllByServiceNameContaining(name).stream().map(Ad::getAdDto).collect(Collectors.toList());
	}
}
