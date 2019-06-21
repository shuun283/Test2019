package rin;

/**
 *
 * @author sys-user
 *
 */
public class Lesson3Action {

	public static void main(String[] args) {
		//例①
		CharSequence seq = "123456";
		StringBuffer sbf = new StringBuffer(seq);
		StringBuilder sb = new StringBuilder(seq);
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
			System.out.println("例外：" + nfEx.getMessage());
		}

	}


}
