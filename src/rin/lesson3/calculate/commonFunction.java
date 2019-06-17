package rin.lesson3.calculate;

public class commonFunction {

	public static String[] OPERATORS = {"(",")","+","-","*","/"};

	/**
	 * 
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
	 * 
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
}
