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
		cars = new MyBTree(100);
	}
	
	public boolean offer(Car car) {
		return cars.insert(car);
	}
	
	public void sell(Car car) {
		cars.delete(car);
	}
	
	public void printCarsForSale() {
		cars.printInOrder();
	}
	
	public BTree getCars() {
		return cars;
	}

}
