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
        
        // ����һ���������飬����Ϊ10
		int[] nums = new int[10];
        
        //ͨ��ѭ�������鸳ֵ
		for (int i = 0; i < nums.length; i++) {
            // ����10���ڵ������
			int x = (int)(Math.random()*10);
            
			nums[i] = x;// ΪԪ�ظ�ֵ
		}
        
		// ʹ��foreachѭ����������е�Ԫ��
		for (int num : nums) {
			System.out.print(num + " ");
		}
	}
}