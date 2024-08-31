package com.servicebookingsystem.dto;

import java.util.Date;

import com.servicebookingsystem.enums.ReservationStatus;
import com.servicebookingsystem.enums.ReviewStatus;

public class ReservationDTO {

	private Long id;
	
	private Date bookDate;
	
	private String serviceName;
	
	private ReservationStatus reservationStatus;
	
	private ReviewStatus reviewStatus;
	
	private Long userId;
	
	private String userName;
	
	private Long companyId;
	
	private Long adId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBookDate() {
		return bookDate;
	}

	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public ReservationStatus getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(ReservationStatus reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public ReviewStatus getReviewStatus() {
		return reviewStatus;
	}

	public void setReviewStatus(ReviewStatus reviewStatus) {
		this.reviewStatus = reviewStatus;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getAdId() {
		return adId;
	}

	public void setAdId(Long adId) {
		this.adId = adId;
	}

	/**
	 * @param id
	 * @param bookDate
	 * @param serviceName
	 * @param reservationStatus
	 * @param reviewStatus
	 * @param userId
	 * @param userName
	 * @param companyId
	 * @param adId
	 */
	public ReservationDTO(Long id, Date bookDate, String serviceName, ReservationStatus reservationStatus,
			ReviewStatus reviewStatus, Long userId, String userName, Long companyId, Long adId) {
		super();
		this.id = id;
		this.bookDate = bookDate;
		this.serviceName = serviceName;
		this.reservationStatus = reservationStatus;
		this.reviewStatus = reviewStatus;
		this.userId = userId;
		this.userName = userName;
		this.companyId = companyId;
		this.adId = adId;
	}

	/**
	 * 
	 */
	public ReservationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
