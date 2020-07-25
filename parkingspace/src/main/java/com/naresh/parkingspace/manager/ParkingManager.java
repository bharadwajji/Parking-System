package com.naresh.parkingspace.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.naresh.parkingspace.exception.InvalidParkingIdException;
import com.naresh.parkingspace.exception.ParkingNotAvailableException;
import com.naresh.parkingspace.model.Parking;
import com.naresh.parkingspace.model.ParkingReciept;
import com.naresh.parkingspace.model.ParkingReport;
import com.naresh.parkingspace.model.ParkingVehicle;
import com.naresh.parkingspace.model.VehicleInfo;
import com.naresh.parkingspace.pool.ParkingPool;

@Component
public class ParkingManager {
	
	
	@Autowired
	private ParkingPool parkingPool;
	
	private ConcurrentHashMap<String, ParkingVehicle> parkingMap = new ConcurrentHashMap<String, ParkingVehicle>();
	private Map<String,ParkingReciept> historicalParkingMap = new HashMap<>();
	
	public ParkingVehicle allotParking(VehicleInfo vehicleInfo) {
		Parking parking = parkingPool.getParkingSpace().orElseThrow(ParkingNotAvailableException::new);
		parkingMap.put(parking.getParkingId(), new ParkingVehicle(parking, vehicleInfo));
		return parkingMap.get(parking.getParkingId());
	}
	
	public ParkingReciept returnParking(String parkingId) {
		if(parkingMap.containsKey(parkingId)) {
			ParkingVehicle parkVehicle = parkingMap.get(parkingId);
			parkingMap.remove(parkingId);
			parkingPool.returnParkingSpace(new Parking(parkVehicle.getParkingSpaceId()));
			historicalParkingMap.put(parkVehicle.getParkingId(), new ParkingReciept(parkVehicle));
			return historicalParkingMap.get(parkVehicle.getParkingId());
		}
		else {
			throw new InvalidParkingIdException();
		}
	}
	
	public ParkingReport generateParkingReport() {
		List<ParkingVehicle> parkingVehicleList = getUsedParkingData();
		return new ParkingReport(parkingPool.numberOfAvailableParking(), parkingVehicleList.size(), parkingVehicleList);
	}
	
	public List<ParkingReciept> generateParkingHistoricalReport() {
		return historicalParkingMap.values().stream().collect(Collectors.toList());
	}
	
	private List<ParkingVehicle> getUsedParkingData(){
		return parkingMap.values().stream().collect(Collectors.toList());
	}
	
	  
}