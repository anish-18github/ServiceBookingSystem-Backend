package com.servicebookingsystem.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicebookingsystem.dto.AdDTO;
import com.servicebookingsystem.dto.ReservationDTO;
import com.servicebookingsystem.services.company.CompanyService;

@RestController
@RequestMapping("/api/company")
@CrossOrigin(origins = "${FRONTEND_URL}", exposedHeaders = "Authorization") // Consider moving this to a global config
public class CompanyController {
	
	@Value("${FRONTEND_URL}")
    private String frontendUrl;

	@Autowired
	private CompanyService companyService;

	
	@PostMapping("/ad/{userId}")
	public ResponseEntity<?> postAd(@PathVariable Long userId, @ModelAttribute AdDTO adDTO) {
		try {
			boolean success = companyService.postAd(userId, adDTO);
			if (success) {
				return ResponseEntity.status(HttpStatus.OK).build();
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Consider a different status for failed
																			// save
			}
		} catch (IOException e) {
			// Log the exception for debugging
			System.err.println("Error while posting ad: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing the ad");
		}
	}
 
	
	@GetMapping("/ads/{userId}")
	public ResponseEntity<?> getAllAdsByUserId(@PathVariable Long userId) {
		try {
			return ResponseEntity.ok(companyService.getAllAds(userId));
		} catch (Exception e) {
			// Handle any unexpected errors
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch ads");
		}
	}

	
	@GetMapping("/ad/{adId}")
	public ResponseEntity<?> getAdById(@PathVariable Long adId) {
		try {
			AdDTO adDTO = companyService.getAdById(adId);
			if (adDTO != null) {
				return ResponseEntity.ok(adDTO);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ad not found");
			}
		} catch (Exception e) {
			// Handle unexpected errors
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch the ad");
		}
	}

	
	@PutMapping("/ad/{adId}")
	public ResponseEntity<?> updateAd(@PathVariable Long adId, @ModelAttribute AdDTO adDTO) throws IOException {
		boolean success = companyService.updateAd(adId, adDTO);
		if (success) {
			return ResponseEntity.status(HttpStatus.OK).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	
	@DeleteMapping("/ad/{adId}")
	public ResponseEntity<?> deleteAd(@PathVariable Long adId){
		boolean success = companyService.deleteAd(adId);
		
		if (success) {
			return ResponseEntity.status(HttpStatus.OK).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	
	@GetMapping("/bookings/{companyId}")
	public ResponseEntity<List<ReservationDTO>> getAllAdBookings(@PathVariable Long companyId){
		return ResponseEntity.ok(companyService.getAllAdBookings(companyId));
	}
	
	@GetMapping("/booking/{bookingId}/{status}")
	public ResponseEntity<?> changeBookingStatus(@PathVariable Long bookingId, @PathVariable String status){
		boolean success = companyService.changeBookingStatus(bookingId, status);
		if (success) {
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
