package shuun.chapte2;

public class Sample02 {

	public static void main(String[] args) {
		byte b = 127;
		char c = 'A', c1 = '\u003d';
		short s = 61;
		int i = 0;
		long l = 0l;
		float f = 0.1f;
		double d = 0.1d;
		boolean bl = false;
		String str = "";

		
//		b = 128;
//		c = "Aa";
//		i = l;
//		b = (byte)128;
//		System.out.println(b);
		
//		i = l;
//		i = (int)l;
//		System.out.println(i);
		
		i = (int)2147483648l;
		System.out.println(i);
		
		l = 2147483648l;
		System.out.println(l);
		
	}

}
