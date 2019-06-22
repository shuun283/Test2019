package shuun.chapte4;

public class StringEquals {

	public static void main(String[] args) {
		String str1 = "Hello Dear!";
		String str2 = "Hello Dear!";
		String str3 = new String("Hello Dear!");

		if (str1.equals(str2)) {
			System.out.println("str1.equals(str2) : true");
		} else {
			System.out.println("str1.equals(str2) : false");
		}

		if (str1 == str2) {
			System.out.println("str1 == str2 : true");
		} else {
			System.out.println("str1 == str2 : false");
		}

		if (str1.equals(str3)) {
			System.out.println("str1.equals(str3) : true");
		} else {
			System.out.println("str1.equals(str3) : false");
		}

		if (str1 == str3) {
			System.out.println("str1 == str3 : true");
		} else {
			System.out.println("str1 == str3 : false");
		}
	}

}
