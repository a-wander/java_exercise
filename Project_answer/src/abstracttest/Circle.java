package abstracttest;

public class Circle extends shape {

	int r=3;
	
	@Override
	public void zc() {
		// TODO Auto-generated method stub
		double rzc = 2*3.14*r;
		System.out.println("输出圆的周长"+rzc);
	}

	@Override
	public void mj() {
		// TODO Auto-generated method stub
		double rmj = 3.14*r*r;
		System.out.println("输出圆的面积"+rmj);
	}

}
