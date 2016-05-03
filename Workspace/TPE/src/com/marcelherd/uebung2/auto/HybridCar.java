package com.marcelherd.uebung2.auto;

/**
 * A car that uses gasoline and electric power as fuel.
 * 
 * @author Manuel Schwalm
 * @author Marcel Herd
 */
public class HybridCar extends Car implements Electric, Gasoline {
	
	public static final String FUEL_TYPE = "Hybrid";
	
	private int emissionTier;
	private int voltage;

	@Override
	public int getEmissionTier() {
		return emissionTier;
	}
	
	public void setEmissionTier(int emissionTier) {
		this.emissionTier = emissionTier;
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
	public String getFuelType() {
		return HybridCar.FUEL_TYPE;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getBrand() + ", ");
		builder.append(getConstructionYear() + ", ");
		builder.append(getPrice() + ", ");
		builder.append("Kraftstoffart: " + getFuelType() + " ");
		builder.append("(EmissionTier " + getEmissionTier() + ", " + (getVoltage() == Electric.HIGH_VOLTAGE ? "High Voltage" : "Low Voltage") + ")");
		builder.append("\n");
		return builder.toString();
	}

}
