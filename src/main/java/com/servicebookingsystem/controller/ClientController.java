package com.servicebookingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicebookingsystem.dto.ReservationDTO;
import com.servicebookingsystem.services.client.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@CrossOrigin(origins = "http://localhost:4200", exposedHeaders = "Authorization")
	@GetMapping("/ads")
	public ResponseEntity<?> getAllAds(){
		return ResponseEntity.ok(clientService.getAllAds());
	}

	@CrossOrigin(origins = "http://localhost:4200", exposedHeaders = "Authorization")
	@GetMapping("/search/{name}")
	public ResponseEntity<?> searchAdByService(@PathVariable String name){
		return ResponseEntity.ok(clientService.searchAdByName(name));
	}
	
	@CrossOrigin(origins = "http://localhost:4200", exposedHeaders = "Authorization")
	@PostMapping("/book-service")
	public ResponseEntity<?> bookService(@RequestBody ReservationDTO reservationDTO){
		boolean success = clientService.bookService(reservationDTO);
		
		if (success) {
			return ResponseEntity.status(HttpStatus.OK).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}
	}
}
