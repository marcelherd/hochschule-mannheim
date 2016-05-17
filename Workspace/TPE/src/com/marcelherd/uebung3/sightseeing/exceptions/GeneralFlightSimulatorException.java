package com.marcelherd.uebung3.sightseeing.exceptions;

public class GeneralFlightSimulatorException extends Exception {

	private static final long serialVersionUID = 7650756068959338860L;

	/**
	 * {@inheritDoc}
	 */
	public GeneralFlightSimulatorException() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	public GeneralFlightSimulatorException(String message, Throwable cause, boolean enableSuppresion, boolean writableStackTrace) {
		super(message, cause, enableSuppresion, writableStackTrace);
	}

	/**
	 * {@inheritDoc}
	 */
	public GeneralFlightSimulatorException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * {@inheritDoc}
	 */
	public GeneralFlightSimulatorException(String message) {
		super(message);
	}

	/**
	 * {@inheritDoc}
	 */
	public GeneralFlightSimulatorException(Throwable cause) {
		super(cause);
	}

}
