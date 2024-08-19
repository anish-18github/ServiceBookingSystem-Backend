package com.servicebookingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servicebookingsystem.entity.Ad;

@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {

}
