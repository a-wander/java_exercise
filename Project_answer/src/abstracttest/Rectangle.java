package abstracttest;

public class Rectangle extends shape {

	int weight = 3;
	int hight = 4;
	
	@Override
	public void zc() {
		// TODO Auto-generated method stub
		int jxzc = 2*(weight+hight);
		System.out.println("输出矩形的周长"+jxzc);
	}

	@Override
	public void mj() {
		// TODO Auto-generated method stub
		int jxmj = (weight * hight)/2;
		System.out.println("输出矩形的面积"+jxmj);
	}

}
