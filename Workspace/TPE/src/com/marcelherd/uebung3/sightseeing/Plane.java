package com.marcelherd.uebung3.sightseeing;

import com.marcelherd.uebung3.sightseeing.exceptions.GeneralFlightSimulatorException;

public interface Plane {
	/**
	/* Opens the doors of the airplane.
	*  To be able to open the doors the airplane must stop on ground.
	* @throws GeneralFlightSimulatorException
	*         If airplane is in the air or doesn't stop on ground.
	*/
	public void openDoors() throws GeneralFlightSimulatorException;
	/**
	* Closes the doors of the airplane.
	*/
	public void closeDoors();
	/**
	* Stops the airplan when it moves on ground.
	* @throws GeneralFlightSimulatorException
	*        If the airplane is in the air
	*/
	public void stop() throws GeneralFlightSimulatorException;
	/**
	* Lets the airplane go on one more kilometer, the altitude difference is passed as parameter
	* @param additionalHeight
	*        The altitude difference the airplane is ascending/descending for the next kilometer
	*        positive -> ascending, negative -> descending
	*        niedriger fliegt als zuvor. Kann positiv oder negativ sein.
	* @throws GeneralFlightSimulatorException
	*        If problems occur while flying.
	1
	*        Falls beim Fliegen Probleme auftauchen.
	*/
	public void flyNextKilometer(int additionalHeight) throws
	GeneralFlightSimulatorException;
}
