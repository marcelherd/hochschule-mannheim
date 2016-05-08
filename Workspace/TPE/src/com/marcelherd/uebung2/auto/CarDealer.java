package com.marcelherd.uebung2.auto;

import com.marcelherd.uebung1.model.BTree;
import com.marcelherd.uebung1.model.MyBTree;

/**
 * A car that uses gasoline as fuel.
 * 
 * @author Manuel Schwalm
 * @author Marcel Herd
 */
public class CarDealer {
	
	private BTree cars;
	
	public CarDealer() {
		cars = new MyBTree(1);
	}
	
	/**
	 * Returns true if the car dealer is able to incorporate this car into his assortment.
	 * 
	 * @param car - car that the dealer should incorporate into his assortment
	 * @return true if the car dealer is able to incorporate this car into his assortment
	 */
	public boolean offer(Car car) {
		return cars.insert(car);
	}
	
	/**
	 * Sells the car and removes it from the dealers assortment.
	 * 
	 * @param car - car that is being sold
	 */
	public void sell(Car car) {
		cars.delete(car);
	}
	
	/**
	 * Lists alls cars, that the dealer currently has for sale.
	 */
	public void printCarsForSale() {
		cars.printInOrder();
	}
	
	/**
	 * Returns all cars that the dealer is currently offering
	 * 
	 * @return all cars that the dealer is currently offering
	 */
	public BTree getCars() {
		return cars;
	}

}
