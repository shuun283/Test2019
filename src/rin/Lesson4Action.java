package rin;

public class Lesson4Action {

	/**
	 * 四則演算する
	 * <pre>
	 * "\"⇒"\\\\"
	 * "+"⇒"\\+"
	 * "*"⇒"\\*"
	 * "."⇒"\\."
	 * </pre>
	 * @param args
	 */
	public static void main(String[] args) {
		//例①
//		CharSequence seq = "123456";
//		StringBuilder sb = new StringBuilder(seq);
//		System.out.println(seq);

		//例②
		/**
		 * parseInt VS valueOf（例外発生率が一緒）
		 * parseInt をお勧め（パフォーマンス高い）
		 */
		try {
//			int i1 = Integer.parseInt("");
//			System.out.println("i1は " + i1 );//例外
//			int i2 = Integer.valueOf("");
//			System.out.println("i2は " + i2);//例外
//
//			int i3 = Integer.parseInt(null);
//			System.out.println("i1は " + i3 );//例外null
//			int i4 = Integer.valueOf(null);
//			System.out.println("i2は " + i4);//例外null

//			Integer i5 = Integer.parseInt(null);
//			System.out.println("i1は " + i5 );//例外null
			Integer i6 = Integer.valueOf(null);
			System.out.println("i2は " + i6);//例外null
		} catch (NumberFormatException nfEx) {
			// 例外処理
			System.out.println("例外："+nfEx.getMessage());
		}

		//例③
//		String targetStr = "00999+12-12*2/6";
//		int result = doCalcute(targetStr);
//		System.out.println(result);
	}

	/**
	 * 加算機【四則演算】
	 * @param targetStr
	 * @return
	 */
	public static int doCalcute(String targetStr) {
		int result = 0;

		String[] numArr = targetStr.split("\\+");
		for (String num : numArr) {
			result = result + Integer.parseInt(num);
		}
		return result;
	}
}
