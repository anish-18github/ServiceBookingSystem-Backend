package com.servicebookingsystem.services.company;



import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicebookingsystem.dto.AdDTO;
import com.servicebookingsystem.entity.Ad;
import com.servicebookingsystem.entity.User;
import com.servicebookingsystem.repository.AdRepository;
import com.servicebookingsystem.repository.UserRepository;



@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AdRepository adRepository;
	
	public boolean postAd(Long userId, AdDTO adDTO) throws IOException{
		Optional<User> optionalUser = userRepository.findById(userId);
		if (optionalUser.isPresent()) {
			Ad ad = new Ad();
			ad.setServiceName(adDTO.getServiceName());
			ad.setDescription(adDTO.getDescription());
			ad.setImg(adDTO.getImg().getBytes());
			ad.setPrice(adDTO.getPrice());
			ad.setUser(optionalUser.get());
			
			
			adRepository.save(ad);
			return true;
			
		}
		return false;
		
	}
}
