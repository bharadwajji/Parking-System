package com.naresh.parkingspace.model;

import java.util.UUID;

public class Parking {
	
	private String parkingId;
	private String parkingSpaceId;
	
	public Parking(String parkingSpaceId) {
		this.parkingSpaceId = parkingSpaceId;
		this.parkingId = UUID.randomUUID().toString();
	}
	
	public Parking(String parkingId,String parkingSpaceId) {
		this.parkingId = parkingId;
		this.parkingSpaceId = parkingSpaceId;
	}
	
	public String getParkingId() {
		return parkingId;
	}
	public String getParkingSpaceId() {
		return parkingSpaceId;
	}
}