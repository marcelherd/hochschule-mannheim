package com.marcelherd.uebung2.auto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.marcelherd.uebung2.auto.util.Cars;

/**
 * Application entry-point.
 * 
 * @author Manuel Schwalm
 * @author Marcel Herd
 */
public class Application {
	
	public static void main(String[] args) {
		CarDealer dealer = new CarDealer();
		List<Car> cars = new ArrayList<Car>();
		cars.addAll(Arrays.asList(new Car[] { Cars.BMW, Cars.AUDI, Cars.TESLA, Cars.VW }));
		
		for (Car car : cars) {
			dealer.offer(car);
		}
		
		dealer.printCarsForSale();
	}

}
