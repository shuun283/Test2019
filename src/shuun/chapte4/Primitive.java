package shuun.chapte4;

public class Primitive {

	public static void main(String[] args) {
		Byte b = 4;
		Byte wByte = new Byte(b);
		Double d = 345.67;
		Double wDouble = new Double(d);

		System.out.println(wByte);
		System.out.println(wByte.doubleValue());
		
		Byte valueOf = wByte.valueOf(b);
		System.out.println(valueOf);

		System.out.println(wDouble);
		System.out.println(wDouble.byteValue());

		
	}

}
