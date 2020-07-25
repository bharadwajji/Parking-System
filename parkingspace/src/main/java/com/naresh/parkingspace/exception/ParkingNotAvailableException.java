package com.naresh.parkingspace.exception;

public class ParkingNotAvailableException extends RuntimeException {
	
	private static final long serialVersionUID = -1485211082427580122L;
	
	public ParkingNotAvailableException() {
		super();
	}
	
	public ParkingNotAvailableException(String message) {
		super(message);
	}
	
	public ParkingNotAvailableException(String message,Throwable ex) {
		super(message, ex);
	}
}