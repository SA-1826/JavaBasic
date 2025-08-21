package method.q09;

public class Even {
	public static void main(String[] args) {
		int i = 5;
		boolean result = checkEven(i);
		String text = result ? "偶数" : "奇数";
		System.out.println(i + "は" + text + "です。");
	}

	static boolean checkEven(int a) {
		boolean result;
		if (a % 2 == 0) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}
}
