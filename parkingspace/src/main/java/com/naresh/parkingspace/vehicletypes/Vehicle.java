package com.naresh.parkingspace.vehicletypes;

import com.naresh.parkingspace.enums.VehicleType;

public interface Vehicle {
	
	public VehicleType getVehicleType();
	public int getHourlyParkingCost();
	public int getDailyParkingCost();

}
