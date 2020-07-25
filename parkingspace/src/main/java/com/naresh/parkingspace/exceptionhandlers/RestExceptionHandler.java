package com.naresh.parkingspace.exceptionhandlers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.naresh.parkingspace.exception.InvalidParkingIdException;
import com.naresh.parkingspace.exception.ParkingNotAvailableException;
import com.naresh.parkingspace.model.ApiError;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { InvalidParkingIdException.class })
	protected ResponseEntity<Object> handleInvalidParkingConflict(RuntimeException ex, WebRequest request) {
		return buildResponseEntity(new ApiError(HttpStatus.EXPECTATION_FAILED, "ParkingId is invalid", ex));
	}

	@ExceptionHandler(value = { ParkingNotAvailableException.class })
	protected ResponseEntity<Object> handleParkingNotAvailable(RuntimeException ex, WebRequest request) {
		return buildResponseEntity(
				new ApiError(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS, "No Parking is Available at this Moment", ex));
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			errors.put(fieldName, error.getDefaultMessage());
		});
		return new ResponseEntity<>(errors, status);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(
			HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		System.out.println(ex.getMostSpecificCause());
		System.out.println(ex.getMessage());
		ex.printStackTrace();
		return handleExceptionInternal(ex, null, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleBindException(
			BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			errors.put(fieldName, error.getDefaultMessage());
		});
		return new ResponseEntity<>(errors, status);
	}
	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
}
