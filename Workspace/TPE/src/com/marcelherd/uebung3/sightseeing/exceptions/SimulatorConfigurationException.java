package com.marcelherd.uebung3.sightseeing.exceptions;

public class SimulatorConfigurationException extends Exception {

	private static final long serialVersionUID = 6011982354990751197L;

	/**
	 * {@inheritDoc}
	 */
	public SimulatorConfigurationException() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	public SimulatorConfigurationException(String message, Throwable cause, boolean enableSuppresion, boolean writableStackTrace) {
		super(message, cause, enableSuppresion, writableStackTrace);
	}

	/**
	 * {@inheritDoc}
	 */
	public SimulatorConfigurationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * {@inheritDoc}
	 */
	public SimulatorConfigurationException(String message) {
		super(message);
	}

	/**
	 * {@inheritDoc}
	 */
	public SimulatorConfigurationException(Throwable cause) {
		super(cause);
	}

}
