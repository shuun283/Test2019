package shuun.chapte6;

public class LocalClass {

	public static void main(String[] args) {
		LocalOuter outer = new LocalOuter();
		outer.method("param1", "param2");
	}

}

class LocalOuter{

	private String outerVal = "outerVal";
	
	public void method(final String param1, String param2) {
		final int x = 10;
		int y = 20;
		
		// ローカルクラスの定義
		class LocalInner{
			void method() {
				System.out.println("outerVal : " + outerVal );
				System.out.println("x        : " + x );
				System.out.println("y        : " + y );          // NG?
				System.out.println("param1   : " + param1 );
				System.out.println("param2   : " + param2 );     // NG?
			}
		}
		LocalInner localInner = new LocalInner();
		localInner.method();
	}
}