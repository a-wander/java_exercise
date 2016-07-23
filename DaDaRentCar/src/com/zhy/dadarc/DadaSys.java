package com.zhy.dadarc;

import java.util.Scanner;

public class DadaSys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("欢迎使用嗒嗒租车系统：");
		System.out.println("您是否需要租车：1是 0否");
		Scanner input = new Scanner(System.in);
		int nsel = input.nextInt();
		input.close();
		if (nsel == 0) {
			return;
		}
		if (nsel != 1) {
			System.out.println("输入错误！系统退出！");
			return;
		}
		System.out.println("您可租车的类型及其价目表：");
		System.out.println("序号   汽车名称  租金           容量");
		Car[] carForRent = {new PassengerCar(1, "奥迪A4", 500.0,  4),
				            new PassengerCar(2, "马自达6", 400.0, 4),
				            //new Pickup(),
				            new PassengerCar(4, "金龙", 800.0, 20),
				            new Truck(5, "松花江", 400.0, 4),
				            new Truck(6, "依维柯", 1000.0, 20)};
		for(Car car:carForRent){
			car.printNum();
			car.printName();
			car.printRentPrice();
			car.printCapacity();
			System.out.println("");
		}
	}

}
