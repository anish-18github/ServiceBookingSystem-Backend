package com.servicebookingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servicebookingsystem.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
