package com.naresh.parkingspace.decorator;

import com.naresh.parkingspace.enums.ParkingCostType;
import com.naresh.parkingspace.model.ParkingVehicle;

public class HourlyrParkingCost extends VehicleParkingCostDecorator {

	private ParkingVehicle parking;

	public HourlyrParkingCost(ParkingVehicle parking) {
		super(parking.getVehicle());
		this.parking = parking;
	}

	public int getParkingCost() {
		return super.getHourlyParkingCost()
				* getTotalHours();
	}

	@Override
	protected ParkingCostType getCostType() {
		return ParkingCostType.hourly;
	}
	
	private int getTotalHours() {
		long currentTime = System.currentTimeMillis();
		long timeDifference = currentTime - parking.getParkingTime().getTime();
		if(timeDifference%3600 == 0) {
			return (int) (timeDifference/3600000);
		}
		else {
			return (int) (timeDifference/3600000) +1;
		}
	}
}