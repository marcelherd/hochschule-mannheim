package com.marcelherd.uebung3.sightseeing;

import com.marcelherd.uebung3.sightseeing.exceptions.GeneralFlightSimulatorException;

public interface Plane {

	/**
	 * Opens the doors of the airplane. To be able to open the doors the
	 * airplane must stop on ground.
	 * 
	 * @throws GeneralFlightSimulatorException
	 *             If the airplane is in the air or doesn't stop on ground
	 */
	public void openDoors() throws GeneralFlightSimulatorException;

	/**
	 * Closes the doors of the airplane.
	 */
	public void closeDoors();

	/**
	 * Stops the airplane when it moves on ground.
	 * 
	 * @throws GeneralFlightSimulatorException
	 *             If the airplane is in the air
	 */
	public void stop() throws GeneralFlightSimulatorException;

	/**
	 * Starts the airplane.
	 * 
	 * @throws GeneralFlightSimulatorException
	 *             If the airplane is already flying or the doors are open.
	 */
	public void start() throws GeneralFlightSimulatorException;

	/**
	 * Lets the airplane go on one more kilometer, the altitude difference is
	 * passed as parameter.
	 * 
	 * @param additionalHeight
	 *            The altitude difference the airplane is ascending/descending
	 *            for the next kilometer. Positive -> ascending, negative ->
	 *            descending
	 * @throws GeneralFlightSimulatorException
	 *             If problems occur while flying.
	 */
	public void flyNextKilometer(int additionalHeight) throws GeneralFlightSimulatorException;

}
