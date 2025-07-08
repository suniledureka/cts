package com.cognizant.irctc.models;

import java.time.LocalDate;

import com.cognizant.irctc.controllers.adapters.LocalDateAdapter;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Passenger {
	@NotNull(message = "Passenger Name is Required")
	private String passengerName;
	
	@NotEmpty(message = "fromStatic is Required")
	private String fromStation;
	
	@NotBlank(message = "toStation is Required")
	private String toStation;	
	
	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	@NotNull
	//@Past
	@Future
	private LocalDate dateOfJourney;
	
	@NotNull
	@Size(min=3, max=5)
	private String trainNo;
}
