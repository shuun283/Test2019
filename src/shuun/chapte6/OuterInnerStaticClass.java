package shuun.chapte6;

public class OuterInnerStaticClass {

	public static void main(String[] args) {
		// staticな内部クラスのインスタンスを生成
		OuterStaticClass.InnerClass ic = new OuterStaticClass.InnerClass();
		ic.innerSample();
	}

}

//外部クラス
class OuterStaticClass {
	// staticなフィールド
	private static String str = "OuterStaticClassのStatic変数";

	// staticな内部クラス
	static class InnerClass {
		public void innerSample() {
			System.out.println(str);
		}
	}
}
