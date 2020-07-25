package com.naresh.parkingspace.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.parkingspace.model.ParkingReciept;
import com.naresh.parkingspace.model.ParkingReport;
import com.naresh.parkingspace.model.ParkingVehicle;
import com.naresh.parkingspace.model.VehicleInfo;
import com.naresh.parkingspace.service.ParkingService;
import com.naresh.parkingspace.vehicletypes.Vehicle;

@RestController
@RequestMapping("/parking")
public class ParkingController<T extends Vehicle> {

  @Autowired
  private ParkingService parkingService;

  @PostMapping("/allot")
  public ParkingVehicle allotParking(@RequestBody @Valid VehicleInfo vehicleInfo) {
	return parkingService.getParking(vehicleInfo);
  }
  
  @GetMapping("/{parkingId}/exit")
  public ParkingReciept returnParking(@PathVariable(name="parkingId") String parkingId) {
    return parkingService.returnParking(parkingId);
  }
  
  @GetMapping("/report")
  public ParkingReport parkingReport() {
    return parkingService.getParkingReport();
  }
  
  @GetMapping("/report/historical")
  public List<ParkingReciept> parkingHistoricalReport() {
    return parkingService.getParkingHistoricalReport();
  }
 
}