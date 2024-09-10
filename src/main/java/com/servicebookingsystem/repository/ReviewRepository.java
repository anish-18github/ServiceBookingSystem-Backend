package com.servicebookingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servicebookingsystem.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{

}
