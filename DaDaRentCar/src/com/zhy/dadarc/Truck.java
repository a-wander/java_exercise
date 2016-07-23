package com.zhy.dadarc;

public class Truck extends Car {
	private double dCapacity = 0.0;

	public double getdCapacity() {
		return dCapacity;
	}

	public void setdCapacity(double dCapacity) {
		this.dCapacity = dCapacity;
	}

	public Truck() {
		// TODO Auto-generated constructor stub
	}

	public Truck(int nNum, String strName, Double dRentPrice, double dCapacity) {
		super(nNum, strName, dRentPrice);
		// TODO Auto-generated constructor stub
		this.dCapacity = dCapacity;
	}

	@Override
	void printCapacity() {
		// TODO Auto-generated method stub
		System.out.print("‘ÿªı£∫" + dCapacity + "∂÷");
	}
}
