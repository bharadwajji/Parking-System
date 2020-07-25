package com.naresh.parkingspace.vehicletypes;

import com.naresh.parkingspace.enums.VehicleType;

public class TwoWheeler implements Vehicle {

	public VehicleType getVehicleType() {
		return VehicleType.TwoWheeler;
	}

	public int getHourlyParkingCost() {
		return 30;
	}

	public int getDailyParkingCost() {
		return 90;
	}
}