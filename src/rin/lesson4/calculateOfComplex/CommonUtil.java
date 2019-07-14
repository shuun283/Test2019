package rin.lesson4.calculateOfComplex;

public class CommonUtil {

	public static TokenType[] OPERATORS = {
			TokenType.ADD,
			TokenType.MINUS,
			TokenType.MULTIPLY,
			TokenType.DIVIDE,
			TokenType.PAREN_OPEN,
			TokenType.PAREN_CLOSE,
			TokenType.NUMERIC,
	};

	/**
	 * 優先度インデックスを取得する
	 * @param strOpe
	 * @return
	 * @throws Exception 
	 */
	public static int getOperatorPriorityIndex(TokenType tokenType) {
		int len = OPERATORS.length;
		for(int i=0; i<len; i++){
			TokenType ope = OPERATORS[i];
			if(ope.equals(tokenType)){
				return i;
			}
		}
		return -1;
	}

	/**
	 * 優先度比較結果の定義
	 * 縦は一目演算子のインデックス 
	 * +,-,*,/,(,),#
	 * 横は二目演算子のインデックス
	 * +,-,*,/,(,),#
	 * 結果：
	 * 		0はequal; 1はhigher; -1はlower; 9はミスマッチ
	 */
	public static int[][] ope_priority = {
			{ 0, 0,-1,-1,-1,-1,-1},
			{ 0, 0,-1,-1,-1,-1,-1},
			{ 1, 1, 0, 0,-1,-1,-1},
			{ 1, 1, 0, 0,-1,-1,-1},
			{ 1, 1, 1, 1, 0, 0,-1},
			{ 1, 1, 1, 1, 0, 0,-1},
			{ 1, 1, 1, 1, 1, 1, 0},
		};

		/**
		 * 優先度比較結果の定義
		 * 縦は一目演算子のインデックス 
		 * (,),*,/,+,-,#
		 * 横は二目演算子のインデックス
		 * (,),*,/,+,-,#
		 * 結果：
		 * 		0はequal; 1はhigher; -1はlower; 9はミスマッチ
		 */
		public static int[][] ope_priority2 = {
			{ 0, 0, 1, 1, 1, 1, 1},
			{ 0, 0, 1, 1, 1, 1, 1},
			{-1,-1, 0, 0, 1, 1, 1},
			{-1,-1, 0, 0, 1, 1, 1},
			{-1,-1,-1,-1, 0, 0, 1},
			{-1,-1,-1,-1, 0, 0, 1},
			{-1,-1,-1,-1,-1,-1,-1},
//			{ 0, 0, 1, 1, 1, 1, 9},
//			{ 0, 0, 1, 1, 1, 1, 9},
//			{-1,-1, 0, 0, 1, 1, 9},
//			{-1,-1, 0, 0, 1, 1, 9},
//			{-1,-1,-1,-1, 0, 0, 9},
//			{-1,-1,-1,-1, 0, 0, 9},
//			{ 9, 9, 9, 9, 9, 9, 9},
		};

	/**
	 * 演算子の判断
	 * @param c
	 * @return
	 */
	public static boolean isOpe(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/') {
			return true;
		}
		return false;
	}

	/**
	 * 数値の判断
	 * @param c
	 * @return
	 */
	public static boolean isDigit(char c) {
		if ('0'<=c && c<='9') {
			return true;
		}
		return false;
	}
	
	
}
