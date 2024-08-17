package com.servicebookingsystem.services.authentication;

import com.servicebookingsystem.dto.SignupRequestDTO;
import com.servicebookingsystem.dto.UserDto;

public interface AuthService {

	UserDto signupClient(SignupRequestDTO signupRequestDTO);
	
	Boolean presentByEmail(String email);
	
	UserDto signupCompany(SignupRequestDTO signupRequestDTO);
}
