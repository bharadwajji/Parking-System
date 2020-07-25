package com.naresh.parkingspace.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.naresh.parkingspace.enums.ParkingCostType;
import com.naresh.parkingspace.enums.VehicleType;

public class VehicleInfo {

	@Pattern(regexp="[a-zA-Z0-9]*",message="Only digits and characters allowed")
	private String vehicleNumber;
	@Pattern(regexp="[a-zA-Z0-9]*",message="Only digits and characters allowed")
	private String vehicleModel;
	@NotNull(message="VehicleType can not null")
	@Pattern(regexp="FourWheeler|ThreeWheeler|TwoWheeler")
	private String vehicleType;
	@Pattern(regexp="[a-zA-Z0-9]*",message="Only digits and characters allowed")
	private String vehicleBrand;
	@Pattern(regexp="[a-zA-Z0-9]*",message="Only characters allowed")
	private String vehicleColor;
	@Pattern(regexp="daily|hourly")
	private String parkingCostType = ParkingCostType.hourly.name();
	
	public VehicleInfo() {
		
	}
	public VehicleInfo(String vehicleNumber,String vehicleModel,VehicleType vehicleType,String vehicleBrand,String vehicleColor,ParkingCostType parkingCostType) {
		this.vehicleBrand = vehicleBrand;
		this.vehicleColor = vehicleColor;
		this.vehicleModel = vehicleModel;
		this.vehicleNumber = vehicleNumber;
		this.vehicleType = vehicleType.name();
		this.parkingCostType = parkingCostType.name();
		
	}
	
	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public VehicleType getVehicleType() {
		return VehicleType.valueOf(vehicleType);
	}

	public String getVehicleBrand() {
		return vehicleBrand;
	}

	public String getVehicleColor() {
		return vehicleColor;
	}
	public ParkingCostType getParkingCostType() {
		return ParkingCostType.valueOf(parkingCostType);
	}
}
