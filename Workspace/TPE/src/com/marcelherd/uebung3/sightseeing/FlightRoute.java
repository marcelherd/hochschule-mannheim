package com.marcelherd.uebung3.sightseeing;

import com.marcelherd.uebung3.sightseeing.exceptions.SimulatorConfigurationException;

public class FlightRoute {
	
	/**
	 * Length of this flight route in kilometers.
	 */
	private double length;
	
	/**
	 * The lowest allowed altitude for this flight route.
	 */
	private double minAltitude;
	
	/**
	 * The highest allowed altitude for this flight route.
	 */
	private double maxAltitude;
	
	public FlightRoute(double length, double minAltitude, double maxAltitude) throws SimulatorConfigurationException {
		if (length < 0) {
			throw new SimulatorConfigurationException("length must be >= 0: " + length);
		}
		if (minAltitude < 0) {
			throw new SimulatorConfigurationException("minAltitude must be >= 0: " + minAltitude);
		}
		if (maxAltitude < 0) {
			throw new SimulatorConfigurationException("maxAltitude must be >= 0: " + maxAltitude);
		}
		
		this.length = length;
		this.minAltitude = minAltitude;
		this.maxAltitude = maxAltitude;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getMinAltitude() {
		return minAltitude;
	}

	public void setMinAltitude(double minAltitude) {
		this.minAltitude = minAltitude;
	}

	public double getMaxAltitude() {
		return maxAltitude;
	}

	public void setMaxAltitude(double maxAltitude) {
		this.maxAltitude = maxAltitude;
	}

}
