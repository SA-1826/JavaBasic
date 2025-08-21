package method.q05;

public class Triangle {
	public static void main(String[] args) {
		int bottom = 8;
		int height = 5;
		System.out.println("底辺：" + bottom);
		System.out.println("高さ：" + height);

		int result = getTriangleArea(bottom, height);
		System.out.println("三角形の面積：" + result);
	}

	static int getTriangleArea(int a, int b) {
		return a * b / 2;
	}

}
