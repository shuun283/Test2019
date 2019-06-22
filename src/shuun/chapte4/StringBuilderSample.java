package shuun.chapte4;

public class StringBuilderSample {

	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder("ABC");
		sb.append("DEF");
		System.out.println(sb.toString());

		StringBuilder sb1 = new StringBuilder("ABC");
		sb1.indexOf("B");
		System.out.println(sb1.toString());

		StringBuilder sb2 = new StringBuilder("ABC");
		sb2.indexOf("B");
		System.out.println(sb2.toString());

		StringBuilder sb3 = new StringBuilder("ABC");
		sb3.delete(1, 2);
		System.out.println(sb3.toString());

		StringBuilder sb4 = new StringBuilder("ABC");
		sb4.insert(2, "DEF");
		System.out.println(sb4.toString());

		StringBuilder sb5 = new StringBuilder("ABC");
		sb5.replace(0, 1, "DEF");
		System.out.println(sb5.toString());

		StringBuilder sb6 = new StringBuilder("ABC");
		sb6.reverse();
		System.out.println(sb6.toString());
	}

}
