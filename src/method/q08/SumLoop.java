package method.q08;

public class SumLoop {
	public static void main(String[] args) {
		int min = 1;
		int max = 100;
		System.out.println("最小値：" + min);
		System.out.println("最大値：" + max);
		
		int result = sumLoop(min, max);
		System.out.println("加算結果：" + result);
	}

	static int sumLoop(int a, int b) {
		int sum = 0;
		for (int i = a; i <= b; i++) {
			sum = sum + i;
		}
		return sum;
	}

}
