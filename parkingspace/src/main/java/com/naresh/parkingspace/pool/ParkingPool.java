package com.naresh.parkingspace.pool;

import java.util.Optional;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.naresh.parkingspace.model.Parking;

@Component
public class ParkingPool {

	@Value("${parking.totalCount}")
	private int totalNumberOfParking;
	
	private BlockingQueue<Parking> parkingQueue;

	@PostConstruct
	public void addParkingsToQueue() {
		AtomicInteger atomicInt = new AtomicInteger(1);
		parkingQueue = new LinkedBlockingQueue<Parking>();
		for(int i=0;i<totalNumberOfParking;i++) {
			parkingQueue.add(new Parking(atomicInt.getAndIncrement()+""));
		}
	}
	
	public Optional<Parking> getParkingSpace() {
		return Optional.ofNullable(parkingQueue.poll());
	}
	
	public boolean returnParkingSpace(Parking parking) {
		return parkingQueue.offer(parking);
	}
	
	public int numberOfAvailableParking(){
		return parkingQueue.size();
	}
}