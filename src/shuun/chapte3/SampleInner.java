package shuun.chapte3;

public class SampleInner {

	public static void main(String[] args) {

		LocalOuter outer = new LocalOuter();
		outer.method("param1", "param2");
	}

}

class LocalOuter {

	private String outerVal = "outVal";

	public void method(final String param1, String param2) {
		final int x = 10;
		int y = 20;

		// localClass
		class LocalInner {
			void method1() {
				System.out.println("outerVal : " + outerVal);
				System.out.println("x        : " + x);
				System.out.println("y        : " + y); // NG?
				System.out.println("param1   : " + param1);
				System.out.println("param2   : " + param2); // NG?
			}
		}

		LocalInner inner = new LocalInner();
		inner.method1();
	}

}
