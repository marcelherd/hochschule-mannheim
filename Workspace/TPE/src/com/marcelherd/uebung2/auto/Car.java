package com.marcelherd.uebung2.auto;

/**
 * A car.
 * 
 * @author Manuel Schwalm
 * @author Marcel Herd
 */
public abstract class Car implements Comparable<Car> {

	public static long instances = 0;

	private Long id;
	private int constructionYear;
	private double price;
	private String brand;
	
	public Car() {
		instances++;
		id = Car.instances;
	}
	
	/**
	 * Returns the type of fuel that the machine uses to operate.
	 * 
	 * @return the type of fuel that the machine uses to operate
	 */
	public abstract String getFuelType();

	public Long getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getConstructionYear() {
		return constructionYear;
	}

	public void setConstructionYear(int constructionYear) {
		this.constructionYear = constructionYear;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(Car o) {
		return id.compareTo(o.getId());
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Car [id=");
		builder.append(id);
		builder.append(", constructionYear=");
		builder.append(constructionYear);
		builder.append(", price=");
		builder.append(price);
		builder.append(", brand=");
		builder.append(brand);
		builder.append("]");
		return builder.toString();
	}

}
