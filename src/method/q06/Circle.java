package method.q06;

public class Circle {
	public static void main(String[] args) {
		double r = 5.0;
		System.out.println("半径：" + r);

		double result = getCircleArea(r);
		System.out.println("円の面積：" + result);
	}

	static double getCircleArea(double r) {
		return r * r * 3.14;
	}

}
