package teikoumei;

import java.util.ArrayList;
import java.util.List;

public class TestTokenizer {
	public static void main(String[] args) throws Exception {
		TestTokenizer testTokenizer = new TestTokenizer();
		List<String> list = testTokenizer.test("32*((2-2.1)+1 5)/(-15)#");
		for (String s : list) {
			System.out.println("s: " + s);
		}
	}

	public List<String> test(String str) {
		List<String> list = new ArrayList<String>();
		char ch[] = str.toCharArray();
		int i = 0;
		StringBuilder sb = new StringBuilder();
		while (ch[i] != '#') {// 结束符
			if (isNumber1(ch[i])) { // 判断数字
				int temp = i;
				while (isNumber(ch[i]) && ch[i] != '#') {
					i++;
				}
				int j;
				for (j = temp; j < i; j++) {
					sb.append(ch[j]);
				}
				list.add(sb.toString());
				sb.setLength(0);
				i--;
			} else if (ch[i] == '-') { // 判断负号
				if (ch[i - 1] >= '0' && ch[i - 1] <= '9' || ch[i + 1] == ')') {
					list.add("-");// 作为运算符
				} else {
					sb.append("-"); // 作为负数
				}
			} else if (ch[i] == '+') { // 判断加号
				if (i == 0) {
					// System.out.printf("+");
				} else {
					list.add("+");

				}
			} else {
				list.add(String.valueOf(ch[i]));
			}
			i++;
		}
		return list;
	}

	public static boolean isNumber(char c) {
		if (('0' <= c && c <= '9') || c == '.') {
			return true;
		}
		return false;
	}

	public static boolean isNumber1(char c) {
		if ('0' <= c && c <= '9') {
			return true;
		}
		return false;
	}
}
