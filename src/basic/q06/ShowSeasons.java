package basic.q06;

public class ShowSeasons {
	public static void main(String[] args) {
		var month = 1;
		switch (month) {
			case 1, 2, 12 -> System.out.println(month + "月は冬です");
			case 3, 4, 5 -> System.out.println(month + "月は春です");
			case 6, 7, 8 -> System.out.println(month + "月は夏です。");
			case 9, 10, 11 -> System.out.println(month + "月は秋です");
			default -> System.out.println(month + "月は存在しないです。");
		}
	}

}
