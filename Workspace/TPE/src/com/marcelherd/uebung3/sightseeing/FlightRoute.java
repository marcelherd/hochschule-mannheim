package com.marcelherd.uebung3.sightseeing;

import com.marcelherd.uebung3.sightseeing.exceptions.SimulatorConfigurationException;
/**
 * The FlightRoute sets and checks some necessary parameters for the Flight Simulation.
 * 
 **/
public class FlightRoute {

	private int length;
	private int minHeight;
	private int maxHeight;
	/**
	 * The FlightRoute sets and checks some necessary parameters for the Flight Simulation.
	 * 
	 * @param length Route length. Have to be greater than zero.
	 * @param minHeight Minimum height in meter over the city. Have to be greater than zero.
	 * @param maxHeight Maximum height in meter over the city. Have to be greater than zero and greater than minHeight.
	 * @throws SimulatorConfigurationException when there are problems in Route configuration.
	 */
	public FlightRoute(int length, int minHeight, int maxHeight) throws SimulatorConfigurationException{
		if(length <= 0){
			throw new SimulatorConfigurationException("length have to be greater than zero.");
		}
		if(minHeight <= 0){
			throw new SimulatorConfigurationException("minHeight can't be negative.");
		}
		if(maxHeight <= 0){
			throw new SimulatorConfigurationException("maxHeight have to be greater than zero.");
		}
		if(minHeight > maxHeight){
			throw new SimulatorConfigurationException("minHeight: " + minHeight + " have to be smaller than maxHeight: " + maxHeight);
		}
		this.length = length;
		this.minHeight = minHeight;
		this.maxHeight = maxHeight;
	}
	/**
	 * 
	 * @return length of {@link FlightRoute}
	 */
	public int getLength() {
		return length;
	}
	/**
	 * 
	 * @return minimum height of {@link FlightRoute}
	 */
	public int getMinHeight() {
		return minHeight;
	}
	/**
	 * 
	 * @return maximum height of {@link FlightRoute}
	 */
	public int getMaxHeight() {
		return maxHeight;
	}
	
	
	
	
}
