package com.marcelherd.uebung2.auto;

/**
 * A car that uses electric power as fuel.
 * 
 * @author Manuel Schwalm
 * @author Marcel Herd
 */
public class ElectricCar extends Car implements Electric {
	
	public static final String FUEL_TYPE = "Elektro";
	
	private int voltage;
	
	@Override
	public String getFuelType() {
		return ElectricCar.FUEL_TYPE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getVoltage() {
		return voltage;
	}
	
	public void setVoltage(int voltage) {
		if (voltage == Electric.HIGH_VOLTAGE || voltage == Electric.LOW_VOLTAGE) { // this should've been an enum
			this.voltage = voltage;
		} else {
			throw new IllegalArgumentException("Voltage must be " + Electric.HIGH_VOLTAGE + " or " + Electric.LOW_VOLTAGE + ".");
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getBrand() + ", ");
		builder.append(getConstructionYear() + ", ");
		builder.append(getPrice() + ", ");
		builder.append("Kraftstoffart: " + getFuelType() + " ");
		builder.append("(" + (getVoltage() == Electric.HIGH_VOLTAGE ? "High Voltage" : "Low Voltage") + ")");
		builder.append("\n");
		return builder.toString();
	}

}
