package com.marcelherd.uebung2.auto.util;

import com.marcelherd.uebung2.auto.Electric;
import com.marcelherd.uebung2.auto.ElectricCar;
import com.marcelherd.uebung2.auto.GasolineCar;
import com.marcelherd.uebung2.auto.HybridCar;

/**
 * Holds some car instances to play with.
 * 
 * @author Manuel Schwalm
 * @author Marcel Herd
 */
public class Cars {
	
	public static final GasolineCar BMW;
	public static final GasolineCar AUDI;
	public static final ElectricCar TESLA;
	public static final HybridCar VW;
	
	static {
		BMW = new GasolineCar();
		BMW.setBrand("BMW");
		BMW.setConstructionYear(2012);
		BMW.setPrice(25000);
		BMW.setEmissionTier(2);
		
		AUDI = new GasolineCar();
		AUDI.setBrand("Audi");
		AUDI.setConstructionYear(2011);
		AUDI.setPrice(22000);
		AUDI.setEmissionTier(3);
		
		TESLA = new ElectricCar();
		TESLA.setBrand("Tesla");
		TESLA.setConstructionYear(2015);
		TESLA.setPrice(50000);
		TESLA.setVoltage(Electric.HIGH_VOLTAGE);
		
		VW = new HybridCar();
		VW.setBrand("VW");
		VW.setConstructionYear(2014);
		VW.setPrice(30000);
		VW.setEmissionTier(1);
		VW.setVoltage(Electric.LOW_VOLTAGE);
	}

}
