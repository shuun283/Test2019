package shuun.chapte6;

public class OuterInnerClass {

	public static void main(String[] args) {

		// 外部クラスのインスタンスの生成
		// 外部クラス名 外部クラスのオブジェクト名 = new 外部クラス名();
		OuterClass oc = new OuterClass();

		// 外部クラスのオブジェクトから内部クラスのインスタンスを生成
		// 外部クラス名.内部クラス名 内部クラスのオブジェクト名 = 外部クラスのオブジェクト名.new 内部クラス名();
		OuterClass.InnerClass ic = oc.new InnerClass();
		ic.innerSample();
	}

}

//外部クラス
class OuterClass {
	private String str = "OuterClassの変数";

	// 内部クラス
	class InnerClass {
		public void innerSample() {
			System.out.println(str);
		}
	}
}