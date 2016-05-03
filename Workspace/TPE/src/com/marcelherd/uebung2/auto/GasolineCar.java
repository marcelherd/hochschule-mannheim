package com.marcelherd.uebung2.auto;

/**
 * A car that uses gasoline as fuel.
 * 
 * @author Manuel Schwalm
 * @author Marcel Herd
 */
public class GasolineCar extends Car implements Gasoline {
	
	public static final String FUEL_TYPE = "Benzin";
	
	private int emissionTier;

	@Override
	public String getFuelType() {
		return GasolineCar.FUEL_TYPE;
	}
	
	@Override
	public int getEmissionTier() {
		return emissionTier;
	}
	
	public void setEmissionTier(int emissionTier) {
		this.emissionTier = emissionTier;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getBrand() + ", ");
		builder.append(getConstructionYear() + ", ");
		builder.append(getPrice() + ", ");
		builder.append("Kraftstoffart: " + getFuelType() + " ");
		builder.append("(EmissionTier " + getEmissionTier() + ")");
		builder.append("\n");
		return builder.toString();
	}

}
