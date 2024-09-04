package com.servicebookingsystem.dto;

public class AdDetailsForClientDTO {

	private AdDTO adDTO;

	public AdDTO getAdDTO() {
		return adDTO;
	}

	public void setAdDTO(AdDTO adDTO) {
		this.adDTO = adDTO;
	}

	/**
	 * @param adDTO
	 */
	public AdDetailsForClientDTO(AdDTO adDTO) {
		super();
		this.adDTO = adDTO;
	}

	/**
	 * 
	 */
	public AdDetailsForClientDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
