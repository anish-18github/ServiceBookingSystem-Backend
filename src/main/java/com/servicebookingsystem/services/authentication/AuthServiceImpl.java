package com.servicebookingsystem.services.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.servicebookingsystem.dto.SignupRequestDTO;
import com.servicebookingsystem.dto.UserDto;
import com.servicebookingsystem.entity.User;
import com.servicebookingsystem.enums.UserRole;
import com.servicebookingsystem.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService 	{
	
	@Autowired
	private UserRepository userRepository;
	
	public UserDto signupClient(SignupRequestDTO signupRequestDTO) {
		User user = new User();
		
		user.setName(signupRequestDTO.getName());
		user.setLastname(signupRequestDTO.getLastname());
		user.setEmail(signupRequestDTO.getEmail());
		user.setPhone(signupRequestDTO.getPhone());
		user.setPassword(new BCryptPasswordEncoder().encode(signupRequestDTO.getPassword()));
		
		user.setRole(UserRole.CLIENT);
		
		return userRepository.save(user).getDto();
	}
	
	public Boolean presentByEmail(String email) {
		return userRepository.findFirstByEmail(email) != null;
	}
	
	public UserDto signupCompany(SignupRequestDTO signupRequestDTO) {
		User user = new User();
		
		user.setName(signupRequestDTO.getName());
		user.setAddress(signupRequestDTO.getAddress());
		user.setEmail(signupRequestDTO.getEmail());
		user.setPhone(signupRequestDTO.getPhone());
		user.setPassword(new BCryptPasswordEncoder().encode(signupRequestDTO.getPassword()));
		
		user.setRole(UserRole.COMPANY);
		
		return userRepository.save(user).getDto();
	}
	
}
