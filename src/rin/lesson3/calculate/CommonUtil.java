package rin.lesson3.calculate;

public class CommonUtil {

	public static String[] OPERATORS = {"(",")","+","-","*","/"};

	/**
	 * 優先度インデックスを取得する
	 * @param strOpe
	 * @return
	 */
	public static int getOperatorPriorityIndex(String strOpe){
		int len = OPERATORS.length;
		for(int i=0; i<len; i++){
			String ope = OPERATORS[i];
			if(ope.equals(strOpe)){
				return i;
			}
		}
		return len;
	}

	/**
	 * 優先度比較結果の定義
	 * 縦は一目演算子のインデックス 
	 * (,),+,-,*,/,#
	 * 横は二目演算子のインデックス
	 * (,),+,-,*,/,#
	 * 結果：
	 * 		0はequal; 1はhigher; -1はlower; 9はミスマッチ
	 */
	public static int[][] ope_priority = {
			{ 0, 0, 1, 1, 1, 1, 9},
			{ 0, 0, 1, 1, 1, 1, 9},
			{-1,-1, 0, 0,-1,-1, 9},
			{-1,-1, 0, 0,-1,-1, 9},
			{-1,-1, 1, 1, 0, 0, 9},
			{-1,-1, 1, 1, 0, 0, 9},
			{ 9, 9, 9, 9, 9, 9, 9},
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
