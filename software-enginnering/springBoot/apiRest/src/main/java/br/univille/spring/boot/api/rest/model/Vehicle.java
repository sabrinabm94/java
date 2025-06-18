package br.univille.spring.boot.api.rest.model;

public class Vehicle {
	private String plate;
	private float price;

	private int assemblyYear;

	public int getAssemblyYear() {
		return assemblyYear;
	}

	public void setAssemblyYear(int assemblyYear) {
		this.assemblyYear = assemblyYear;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
