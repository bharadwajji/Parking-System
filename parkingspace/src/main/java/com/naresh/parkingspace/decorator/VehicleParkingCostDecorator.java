package com.naresh.parkingspace.decorator;

import com.naresh.parkingspace.enums.ParkingCostType;
import com.naresh.parkingspace.vehicletypes.Vehicle;

public abstract class VehicleParkingCostDecorator {

	private Vehicle vehicle;
	
	public VehicleParkingCostDecorator(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	protected int getHourlyParkingCost() {
		return vehicle.getHourlyParkingCost();
	}
	
	protected int getDailyParkingCost() {
		return vehicle.getDailyParkingCost();
	}
	
	protected abstract ParkingCostType getCostType();
}