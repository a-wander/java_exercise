package abstracttest;

//import java.sql.SQLClientInfoException;
//
//public class ShapeTest {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		shape s1 = new Rectangle();
//		s1.zc();
//		s1.mj();
//		shape s2 = new Circle();
//		s2.zc();
//		s2.mj();
//	}
//
//}

import java.lang.Math;
public class ShapeTest {
    
    public static void main(String[] args) {
        
        // 定义一个整型数组，长度为10
		int[] nums = new int[10];
        
        //通过循环给数组赋值
		for (int i = 0; i < nums.length; i++) {
            // 产生10以内的随机数
			int x = (int)(Math.random()*10);
            
			nums[i] = x;// 为元素赋值
		}
        
		// 使用foreach循环输出数组中的元素
		for (int num : nums) {
			System.out.print(num + " ");
		}
	}
}