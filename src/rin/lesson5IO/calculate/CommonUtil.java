package rin.lesson5IO.calculate;

public class CommonUtil {

	private CommonUtil() {
	}

	/**
	 * POPandPUSHの比較定義
	 * 縦は一目演算子のインデックス +,-,*,/,(,),#
	 * 横は二目演算子のインデックス +,-,*,/,(,),#
	 * 結果：
	 * 1はPOP; 0は捨てる; -1はPUSH
	 */
	public static int[][] pop_dump_push = { // [left][right]
			// r0, r1, r2, r3, r4, r5, r6
			// +, -, *, /, (, ), #
			{ 1, 1, -1, -1, -1, 1, -1 }, // left0「+」
			{ 1, 1, -1, -1, -1, 1, -1 }, // left1「-」
			{ 1, 1, 1, 1, -1, 1, -1 }, // left2「*」
			{ 1, 1, 1, 1, -1, 0, -1 }, // left3「/」
			{ -1, -1, -1, -1, -1, 9, -1 }, // left4「(」
			{ 9, 9, 9, 9, 9, 9, 9 }, // left5「)」
			{ 1, 1, 1, 1, 1, 1, 9 },// left6「#」
	};

	/**
	 * 演算子の判断
	 * 
	 * @param c
	 * @return
	 */
	public static boolean isOpe(final char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/') {
			return true;
		}
		return false;
	}

	/**
	 * 数値の判断
	 * 
	 * @param c
	 * @return
	 */
	public static boolean isDigit(final char c) {
		if ('0' <= c && c <= '9') {
			return true;
		}
		return false;
	}

}
