package com.naresh.parkingspace.vehicletypes;

import com.naresh.parkingspace.enums.VehicleType;

public class ThreeWheeler implements Vehicle {
	
	public VehicleType getVehicleType() {
		return VehicleType.ThreeWheeler;
	}

	public int getHourlyParkingCost() {
		return 50;
	}

	public int getDailyParkingCost() {
		return 150;
	}

}
