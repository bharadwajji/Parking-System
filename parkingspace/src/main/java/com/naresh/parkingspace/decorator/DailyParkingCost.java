package com.naresh.parkingspace.decorator;

import com.naresh.parkingspace.enums.ParkingCostType;
import com.naresh.parkingspace.model.ParkingVehicle;

public class DailyParkingCost extends VehicleParkingCostDecorator  {
	
	private ParkingVehicle parking;

	public DailyParkingCost(ParkingVehicle parking) {
		super(parking.getVehicle());
		this.parking = parking;
	}

	public int getParkingCost() {
		return super.getDailyParkingCost()
				* getTotalDays();
	}

	@Override
	protected ParkingCostType getCostType() {
		return ParkingCostType.daily;
	}
	
	private int getTotalDays() {
		long currentTime = System.currentTimeMillis();
		long timeDifference = currentTime - parking.getParkingTime().getTime();
		if(timeDifference%(3600*24) == 0) {
			return (int) (timeDifference/(3600000*24));
		}
		else {
			return (int) (timeDifference/(3600000*24)) +1;
		}
	}
}