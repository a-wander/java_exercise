package com.zhy.dadarc;

public abstract class Car {
	private int nNum = 0;
	private String strName;
	private double dRentPrice = 0.0;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}
	
	public Car(int nNum, String strName, Double dRentPrice){
		this.nNum = nNum;
		this.strName = strName;
		this.dRentPrice = dRentPrice;
	}
	
	public int getnNum() {
		return nNum;
	}
	public void setnNum(int nNum) {
		this.nNum = nNum;
	}
	public String getStrName() {
		return strName;
	}
	public void setStrName(String strName) {
		this.strName = strName;
	}
	public Double getdRentPrice() {
		return dRentPrice;
	}
	public void setdRentPrice(Double dRentPrice) {
		this.dRentPrice = dRentPrice;
	}
	
	abstract void printCapacity();
	void printNum(){
		System.out.print(nNum + "กฃ");
	}
	void printName(){
		System.out.print(strName);
	}
	void printRentPrice(){
		System.out.print(dRentPrice + "ิช/ฬ์");
	}
}