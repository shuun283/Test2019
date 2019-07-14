package shuun.chapte6;

public class AnonymityClass {

	public static void main(String[] args) {
		AnonymityOuter outer = new AnonymityOuter();

		System.out.println("Create the Inner class object.");
		outer.makeTheInner();
	}

}

class AnonymitySuper {

	private int i = 0;

	public void display() {
		System.out.println("This is MySuper Class.");
		System.out.println("i : " + i);
	}
}

class AnonymityOuter {
	
	private int size = 5;

	public void makeTheInner() {
		// ローカル変数
		String str = "local variable";
		final String finalStr = "final variable";
		
		// AnonymitySuperをスーパークラスとした
		// 匿名クラスを定義
		(new AnonymitySuper(){
			// 匿名クラスのメソッドを定義
			// AnonymitySuperクラスのメソッドのオーバーライド
			public void display() {
				System.out.println("This is Anonymous Class.");
				System.out.println("finalStr : " + finalStr);
				System.out.println("size     : " + size);
				// NG?
				System.out.println("str      : " + str);
			}
		}).display();
	}
}