package com.servicebookingsystem.entity;

import com.servicebookingsystem.dto.UserDto;
import com.servicebookingsystem.enums.UserRole;

import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String email;

	private String password;

	private String name;

	private String lastname;
	
	private String address;

	private String phone;

//	@Enumerated(EnumType.STRING)
	private UserRole role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	

	/**
	 * @param id
	 * @param email
	 * @param password
	 * @param name
	 * @param lastname
	 * @param phone
	 * @param role
	 * @param address 
	 */
	public User(Long id, String email, String password, String name, String lastname, String phone, UserRole role, String address) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.lastname = lastname;
		this.address = address;
		this.phone = phone;
		this.role = role;
	}



	/**
	 * 
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDto getDto() {
		UserDto userDto = new UserDto();
		userDto.setId(id);
		userDto.setName(name);
		userDto.setAddress(address);
		userDto.setEmail(email);
		userDto.setRole(role);

		return userDto;
	}

}
