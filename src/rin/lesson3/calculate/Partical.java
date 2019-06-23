package rin.lesson3.calculate;

import java.util.ArrayList;
import java.util.List;

public class Partical {

	/**
	 * partical
	 * @param chars
	 * @return
	 * @throws Exception
	 */
	public static List<Token> analysisExpression(char[] chars) throws Exception {
		List<Token> tokenList = new ArrayList<Token>();
		for (int idx=0; idx<chars.length; idx++) {
			char c = chars[idx];
			if(c == ' ' || c == '　'){
				continue;
			}

			switch (c){
				case '+':
				case '-':
				case '*':
				case '/':
					String strOpe = getOperator(chars, idx);
					Token tokenOperator = new TokenOperator(strOpe);
					tokenList.add(tokenOperator);
					idx = idx + strOpe.length()-1;
					break;
//				case '(':
//				case ')':
//					//TODO
//					break;
				default:
					if(CommonUtil.isDigit(c)){
						String strNumeric = getNumeric(chars, idx);
						Token tokenNumeric = new TokenNumeric(strNumeric);
						tokenList.add(tokenNumeric);
						idx = idx + strNumeric.length()-1;
						break;
					}else{
						throw new Exception("無効文字です。そのインデックスは"+(idx+1));
					}
			}
			
		}
		return tokenList;
	}

	/**
	 * 
	 * @param chars
	 * @param idx
	 * @return
	 */
	private static String getOperator(char[] chars, int idx) {
		StringBuilder sb = new StringBuilder();
		sb.append(chars[idx]);
		for (int i=idx+1; i<chars.length; i++) {
			char c = chars[i];
			if(CommonUtil.isOpe(c)){
				sb.append(c);
			}else {
				break;
			}
		}
		return sb.toString();
	}

	/**
	 * 
	 * @param chars
	 * @param idx
	 * @return
	 */
	private static String getNumeric(char[] chars, int idx) {
		StringBuilder sb = new StringBuilder();
		sb.append(chars[idx]);
		for (int i=idx+1; i<chars.length; i++) {
			char c = chars[i];
			if(CommonUtil.isDigit(c)){
				sb.append(c);
			}else {
				break;
			}
		}
		return sb.toString();
	}
}
