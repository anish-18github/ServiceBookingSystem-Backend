package com.servicebookingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicebookingsystem.services.client.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/ads")
	public ResponseEntity<?> getAllAds(){
		return ResponseEntity.ok(clientService.getAllAds());
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/search/{name}")
	public ResponseEntity<?> searchAdByService(@PathVariable String name){
		return ResponseEntity.ok(clientService.searchAdByName(name));
	}
}
