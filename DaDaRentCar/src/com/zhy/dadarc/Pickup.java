package com.zhy.dadarc;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Pickup {
	public Map<String, String> testMap;
	
	public int test(){
		Scanner in = new Scanner(System.in);
		int n = 0;
		try {
			n = in.nextInt();
			System.out.println(n);
			in.close();
			n = n / 0;
		} catch (InputMismatchException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(n);
			return n = 3;
		}finally {
			System.out.println("这里终会被执行的!" + n);
			in.close();
		}
		
		return 0;
	}
	
	public void test1()throws Exception{
		throw new Exception("erroe");
	}
	
	public void test2()throws Exception{
		test1();
	}
	
	public static void main(String[] args){
		Pickup pickup = new Pickup();
//		pickup.testMap = new HashMap<String, String>();
//		pickup.testMap.put("test", "map");
//		System.out.println(pickup.test());
		try {
			pickup.test2();
		} catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
