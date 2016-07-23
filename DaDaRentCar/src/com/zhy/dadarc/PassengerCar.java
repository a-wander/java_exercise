package com.zhy.dadarc;

public class PassengerCar extends Car{
	private int nCapacity = 0;
	
	public PassengerCar() {
	}
	
	public PassengerCar(int nNum, String strName, Double dRentPrice, int nCapacity){
		super(nNum,strName,dRentPrice);
		this.nCapacity = nCapacity;
	}
	
	public int getnCapacity() {
		return nCapacity;
	}

	public void setnCapacity(int nCapacity) {
		this.nCapacity = nCapacity;
	}

	@Override
	void printCapacity() {
		// TODO Auto-generated method stub
		System.out.print("‘ÿ»À£∫" + nCapacity + "»À");
	}
}
