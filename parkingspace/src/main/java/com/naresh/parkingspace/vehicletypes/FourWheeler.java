package com.naresh.parkingspace.vehicletypes;

import com.naresh.parkingspace.enums.VehicleType;

public class FourWheeler implements Vehicle {

	public VehicleType getVehicleType() {
		return VehicleType.FourWheeler;
	}
	public int getHourlyParkingCost() {
		return 100;
	}
	public int getDailyParkingCost() {
		return 300;
	}
}