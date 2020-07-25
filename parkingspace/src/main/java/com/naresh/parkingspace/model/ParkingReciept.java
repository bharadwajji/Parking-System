package com.naresh.parkingspace.model;

import java.util.Date;

import com.naresh.parkingspace.enums.ParkingCostType;
import com.naresh.parkingspace.utility.ParkingCostCalculator;
import com.naresh.parkingspace.vehicletypes.Vehicle;

public class ParkingReciept {
	
	private String id;
	private Vehicle vehicle;
	private Date parkingTime;
	private Date exitTime = new Date();
	private String parkingSpaceId;
	private ParkingCostType parkingCostType;
	private int cost;
	private VehicleInfo vehicleInfo;
	
	public ParkingReciept(ParkingVehicle vehicle) {
		this.vehicle = vehicle.getVehicle();
		this.parkingTime = vehicle.getParkingTime();
		this.parkingSpaceId = vehicle.getParkingSpaceId();
		this.id = vehicle.getParkingId();
		this.parkingCostType = vehicle.getParkingCostType();
		this.vehicleInfo = vehicle.getVehicleInfo();
		this.cost = ParkingCostCalculator.calculateParkingCost(vehicle, parkingCostType);
	}

	public String getId() {
		return id;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public Date getParkingTime() {
		return parkingTime;
	}

	public String getParkingSpaceId() {
		return parkingSpaceId;
	}

	public int getCost() {
		return cost;
	}

	public ParkingCostType getParkingCostType() {
		return parkingCostType;
	}

	public Date getExitTime() {
		return exitTime;
	}

	public VehicleInfo getVehicleInfo() {
		return vehicleInfo;
	}
	
	
}
