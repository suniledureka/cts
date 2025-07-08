package com.cognizant.irctc.exceptions;

public class TicketNotFounndException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public TicketNotFounndException() {
		super();		
	}

	public TicketNotFounndException(String message) {
		super(message);		
	}

}
