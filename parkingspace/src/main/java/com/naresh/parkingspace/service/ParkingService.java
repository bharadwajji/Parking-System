package com.naresh.parkingspace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naresh.parkingspace.manager.ParkingManager;
import com.naresh.parkingspace.model.ParkingReciept;
import com.naresh.parkingspace.model.ParkingReport;
import com.naresh.parkingspace.model.ParkingVehicle;
import com.naresh.parkingspace.model.VehicleInfo;

@Service
public class ParkingService {

	@Autowired
	private ParkingManager parkingManager;
	
	public ParkingVehicle getParking(VehicleInfo vehicleInfo) {
		return parkingManager.allotParking(vehicleInfo);
	}
	
	public ParkingReciept returnParking(String parkingId) {
		return parkingManager.returnParking(parkingId);
	}
	
	public ParkingReport getParkingReport() {
		return parkingManager.generateParkingReport();
	}
	
	
	public List<ParkingReciept> getParkingHistoricalReport() {
		return parkingManager.generateParkingHistoricalReport();
	}
}