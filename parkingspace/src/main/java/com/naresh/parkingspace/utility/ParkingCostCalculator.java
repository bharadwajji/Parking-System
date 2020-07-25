package com.naresh.parkingspace.utility;

import com.naresh.parkingspace.decorator.DailyParkingCost;
import com.naresh.parkingspace.decorator.HourlyrParkingCost;
import com.naresh.parkingspace.enums.ParkingCostType;
import com.naresh.parkingspace.model.ParkingVehicle;

public class ParkingCostCalculator {
	
	public static int calculateParkingCost(ParkingVehicle vehicle,ParkingCostType parkingCostType) {
		if(parkingCostType.equals(ParkingCostType.hourly)) {
			return new HourlyrParkingCost(vehicle).getParkingCost();
		}
		else {
			return new DailyParkingCost(vehicle).getParkingCost();
		}
	}
}