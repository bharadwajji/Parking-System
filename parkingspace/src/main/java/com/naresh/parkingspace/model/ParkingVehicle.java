package com.naresh.parkingspace.model;

import java.util.Date;

import com.naresh.parkingspace.enums.ParkingCostType;
import com.naresh.parkingspace.enums.VehicleType;
import com.naresh.parkingspace.vehicletypes.FourWheeler;
import com.naresh.parkingspace.vehicletypes.ThreeWheeler;
import com.naresh.parkingspace.vehicletypes.TwoWheeler;
import com.naresh.parkingspace.vehicletypes.Vehicle;

public class ParkingVehicle extends Parking {
	
	private Vehicle vehicle;
	private Date parkingTime;
	private ParkingCostType parkingCostType;
	private VehicleInfo vehicleInfo;
	
	public ParkingVehicle(Parking parking,VehicleInfo vehicleInfo) {
		super(parking.getParkingId(), parking.getParkingSpaceId());
		this.vehicleInfo = vehicleInfo;
		this.parkingTime = new Date();
		this.parkingCostType = vehicleInfo.getParkingCostType();
		setVehicle();
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public Date getParkingTime() {
		return parkingTime;
	}

	public VehicleInfo getVehicleInfo() {
		return vehicleInfo;
	}
	
	public ParkingCostType getParkingCostType() {
		return parkingCostType;
	}

	private void setVehicle() {
		if(this.vehicleInfo.getVehicleType().toString().equals(VehicleType.FourWheeler.toString())) {
			this.vehicle = new FourWheeler();
		}
		if(this.vehicleInfo.getVehicleType().toString().equals(VehicleType.ThreeWheeler.toString())) {
			this.vehicle = new ThreeWheeler();
		}
		if(this.vehicleInfo.getVehicleType().toString().equals(VehicleType.TwoWheeler.toString())) {
			this.vehicle = new TwoWheeler();
		}
	}
}