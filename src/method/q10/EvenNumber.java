package method.q10;

import java.util.Arrays;

public class EvenNumber {
	public static void main(String[] args) {
		int[] num = { 3, 2, 5, 6, 7, 25, 10, 51, 88, 98 };
		int result = getEvenNumbers(num);
		System.out.println(Arrays.toString(num) + "には、偶数が" + result + "個あります。");
	}

	static int getEvenNumbers(int[] num) {
		int count = 0;
		for (int i = 0; i < 10; i++) {
			if (num[i] % 2 == 0) {
				count++;
			}
		}
		return count;
	}
}
