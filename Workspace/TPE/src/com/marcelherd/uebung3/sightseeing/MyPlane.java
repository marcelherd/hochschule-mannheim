package com.marcelherd.uebung3.sightseeing;

import com.marcelherd.uebung3.sightseeing.exceptions.GeneralFlightSimulatorException;

public class MyPlane implements Plane {
	
	private FlightRoute flightRoute;
	
	/**
	 * True if the airplane is midair.
	 */
	private boolean flying = false;
	
	private boolean doorsClosed = false;
	
	/**
	 * Total distance travelled since starting in km.
	 */
	private double travelled = 0d;
	
	private double altitude = 0d;
	
	public MyPlane(FlightRoute flightRoute) {
		this.flightRoute = flightRoute;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void openDoors() throws GeneralFlightSimulatorException {
		doorsClosed = false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void closeDoors() {
		doorsClosed = true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stop() throws GeneralFlightSimulatorException {
		if (flying) throw new GeneralFlightSimulatorException("Plane cannot stop until it is on the ground!");
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void start() throws GeneralFlightSimulatorException {
		if (flying) throw new GeneralFlightSimulatorException("Plane is already flying, it cannot start!");
		if (! doorsClosed) throw new GeneralFlightSimulatorException("Plane can not start flying while the doors are open!");
		flying = true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void flyNextKilometer(int additionalHeight) throws GeneralFlightSimulatorException {
		if (travelled >= 2d) { // check if min altitude is kept
			double remainingDistance = flightRoute.getLength() - travelled;
			if (remainingDistance > 2d) { // only necessary if further than 2km away from airport
				if (altitude + additionalHeight < flightRoute.getMinAltitude()) {
					double necessaryAdditionalHeight = flightRoute.getMinAltitude() - altitude;
					throw new GeneralFlightSimulatorException("Plane's altitude is too low, eleveate by at least " + necessaryAdditionalHeight);
				}
			}
		}
		travelled++;
	}

}
