package com.zhy.dadarc;

import java.util.Scanner;

public class DadaSys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("��ӭʹ�����⳵ϵͳ��");
		System.out.println("���Ƿ���Ҫ�⳵��1�� 0��");
		Scanner input = new Scanner(System.in);
		int nsel = input.nextInt();
		input.close();
		if (nsel == 0) {
			return;
		}
		if (nsel != 1) {
			System.out.println("�������ϵͳ�˳���");
			return;
		}
		System.out.println("�����⳵�����ͼ����Ŀ��");
		System.out.println("���   ��������  ���           ����");
		Car[] carForRent = {new PassengerCar(1, "�µ�A4", 500.0,  4),
				            new PassengerCar(2, "���Դ�6", 400.0, 4),
				            //new Pickup(),
				            new PassengerCar(4, "����", 800.0, 20),
				            new Truck(5, "�ɻ���", 400.0, 4),
				            new Truck(6, "��ά��", 1000.0, 20)};
		for(Car car:carForRent){
			car.printNum();
			car.printName();
			car.printRentPrice();
			car.printCapacity();
			System.out.println("");
		}
	}

}
