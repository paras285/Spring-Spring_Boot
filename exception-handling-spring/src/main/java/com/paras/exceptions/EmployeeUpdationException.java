package com.paras.exceptions;

public class EmployeeUpdationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1278180773282562910L;

	public EmployeeUpdationException() {
		super();
	}

	public EmployeeUpdationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EmployeeUpdationException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmployeeUpdationException(String message) {
		super(message);
	}

	public EmployeeUpdationException(Throwable cause) {
		super(cause);
	}

}
