package com.naresh.parkingspace.model;

import java.util.ArrayList;
import java.util.List;

public class ParkingReport {

	private int totalParkingAvailable;
	private int totalUsedParking;
	private List<ParkingVehicle> usedParkingList;
	
	public ParkingReport(int totalParkingAvailable,int totalUsedParking,List<ParkingVehicle> usedParkingList){
		this.totalParkingAvailable = totalParkingAvailable;
		this.totalUsedParking = totalUsedParking;
		if(usedParkingList!=null) {
			this.usedParkingList = new ArrayList<ParkingVehicle>(usedParkingList);
		}
	}

	public int getTotalParkingAvailable() {
		return totalParkingAvailable;
	}

	public int getTotalUsedParking() {
		return totalUsedParking;
	}

	public List<ParkingVehicle> getUsedParkingList() {
		return new ArrayList<ParkingVehicle>(usedParkingList);
	}
}
