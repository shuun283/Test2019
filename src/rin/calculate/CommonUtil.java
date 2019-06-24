package rin.calculate;

public class CommonUtil {

	public static TokenType[] OPERATORS = {
			TokenType.PARENT_LEFT
			,TokenType.PARENT_RIGHT
			,TokenType.MULTIPLY
			,TokenType.DIVIDE
			,TokenType.ADD
			,TokenType.MINUS
			,TokenType.NUMERIC
	};

	/**
	 * 優先度インデックスを取得する
	 * @param strOpe
	 * @return
	 * @throws Exception 
	 */
	public static int getOperatorPriorityIndex(TokenType tokenType) throws Exception{
		int len = OPERATORS.length;
		for(int i=0; i<len; i++){
			TokenType ope = OPERATORS[i];
			if(ope.equals(tokenType)){
				return i;
			}
		}
		throw new Exception("未定義の演算子/演算符号");
	}

	/**
	 * 優先度比較結果の定義
	 * 縦は一目演算子のインデックス 
	 * (,),*,/,+,-,#
	 * 横は二目演算子のインデックス
	 * (,),*,/,+,-,#
	 * 結果：
	 * 		0はequal; 1はhigher; -1はlower; 9はミスマッチ
	 */
	public static int[][] ope_priority = {
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
		if(c == '+' || c == '-' || c == '*' || c == '/'){
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
		if('0'<=c && c<='9'){
			return true;
		}
		return false;
	}
	
	
}
