package com.servicebookingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servicebookingsystem.entity.Ad;

@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {
	
	List<Ad> findAllByUserId(Long userId);
}
