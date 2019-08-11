package shuun.chapte4;

public class MathSample {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		int c = -30;
		double d = 100.9;
		double e = 7.5;

		System.out.println("Math.max(int, int)は、大きいほうの引数を返す " + Math.max(a, b));
		System.out.println("Math.min(int, int)は、小さいほうの値を返す " + Math.min(a, b));
		System.out.println("Math.abs(int)。絶対値を返す " + Math.abs(c));
		System.out.println("Math.floor(double)。小数点以下を切り捨て " + Math.floor(d));
		System.out.println("Math.round(double)。小数点以下を四捨五入 " + Math.round(e));
	}

}
