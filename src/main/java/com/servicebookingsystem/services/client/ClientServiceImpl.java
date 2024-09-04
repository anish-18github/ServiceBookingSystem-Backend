package com.servicebookingsystem.services.client;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicebookingsystem.dto.AdDTO;
import com.servicebookingsystem.dto.AdDetailsForClientDTO;
import com.servicebookingsystem.dto.ReservationDTO;
import com.servicebookingsystem.entity.Ad;
import com.servicebookingsystem.entity.Reservation;
import com.servicebookingsystem.entity.User;
import com.servicebookingsystem.enums.ReservationStatus;
import com.servicebookingsystem.enums.ReviewStatus;
import com.servicebookingsystem.repository.AdRepository;
import com.servicebookingsystem.repository.ReservationRepository;
import com.servicebookingsystem.repository.UserRepository;

@Service
public class ClientServiceImpl implements ClientService{

	@Autowired
	private AdRepository adRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	
	public List<AdDTO> getAllAds(){
		return adRepository.findAll().stream().map(Ad::getAdDto).collect(Collectors.toList());
	}
	
	public List<AdDTO> searchAdByName(String name){
		return adRepository.findAllByServiceNameContaining(name).stream().map(Ad::getAdDto).collect(Collectors.toList());
	}
	
	public boolean bookService(ReservationDTO reservationDTO) {
		Optional<Ad> optionalAd = adRepository.findById(reservationDTO.getAdId());
		Optional<User> optionalUser = userRepository.findById(reservationDTO.getUserId());
		
		if (optionalAd.isPresent() && optionalUser.isPresent()) {
			Reservation reservation = new Reservation();
			
			reservation.setBookDate(reservationDTO.getBookDate());
			reservation.setReservationStatus(ReservationStatus.PENDING);
			reservation.setUser(optionalUser.get());
			
			reservation.setAd(optionalAd.get());
			reservation.setCompany(optionalAd.get().getUser());
			reservation.setReviewStatus(ReviewStatus.FALSE);
			
			reservationRepository.save(reservation);
			return true;
		}
		return false;
	}
	
	public AdDetailsForClientDTO getAdDetailsByAdId(Long adId) {
		Optional<Ad> optionalAd = adRepository.findById(adId);
		AdDetailsForClientDTO adDetailsForClientDTO = new AdDetailsForClientDTO();
		
		if (optionalAd.isPresent()) {
			adDetailsForClientDTO.setAdDTO(optionalAd.get().getAdDto());
			
		}
		return adDetailsForClientDTO;
	}
}
