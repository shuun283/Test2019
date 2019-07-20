package shuun.chapte7.recursion;

public class Recursive {

	public static void main(String[] args) throws Exception {
		System.out.println(func(5));
	}

	// 階乗を計算
	public static int func(int i) {
		if (i > 1) {
			int v = i * func(i - 1);
			return v;
		} else {
			return 1;
		}
	}
}
