package com.marcelherd.uebung2.auto;

/**
 * A machine that is powered by electric power.
 * 
 * @author Manuel Schwalm
 * @author Marcel Herd
 */
public interface Electric {
	
	/**
	 * Machine is operating at high voltage: 600V
	 */
	int HIGH_VOLTAGE = 600;
	
	/**
	 * Machine is operating at low voltage: 480V
	 */
	int LOW_VOLTAGE = 480;
	
	/**
	 * Returns {@value #HIGH_VOLTAGE} or {@value #LOW_VOLTAGE}.
	 * 
	 * @return {@value #HIGH_VOLTAGE} or {@value #LOW_VOLTAGE}
	 */
	int getVoltage();

}
