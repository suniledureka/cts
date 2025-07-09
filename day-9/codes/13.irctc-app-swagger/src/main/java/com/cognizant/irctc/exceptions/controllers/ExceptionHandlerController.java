package com.cognizant.irctc.exceptions.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cognizant.irctc.exceptions.TicketNotFounndException;
import com.cognizant.irctc.models.ApiError;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(value = TicketNotFounndException.class)
	public ResponseEntity<?> handleTicketNotFoundException(TicketNotFounndException tex, HttpServletRequest request) {
		// return ResponseEntity.badRequest().body(tex.getMessage());

		ApiError apiError = new ApiError();
		apiError.setMessage(tex.getMessage());

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime ldt = LocalDateTime.now();
		String exDate = formatter.format(ldt);
		apiError.setDate(exDate);

		String exType = tex.getClass().getName();
		apiError.setType(exType);

		String path = request.getRequestURI();
		apiError.setPath(path);

		return new ResponseEntity<ApiError>(apiError, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationFailures(MethodArgumentNotValidException ex) {
		/*
		 * BindingResult bindingResult = ex.getBindingResult(); List<FieldError>
		 * fieldErrors = bindingResult.getFieldErrors();
		 * System.out.println(fieldErrors.size());
		 * 
		 * for (FieldError fieldErr : fieldErrors) {
		 * System.out.println(fieldErr.getField() + " - " +
		 * fieldErr.getDefaultMessage()); }
		 */

		List<String> errors = ex.getBindingResult()
								.getFieldErrors()
								.stream()
								.map(except -> except.getField() + ": " + except.getDefaultMessage())
								.collect(Collectors.toList());

		return new ResponseEntity<List<String>>(errors, HttpStatus.BAD_REQUEST);
		
	}
}
