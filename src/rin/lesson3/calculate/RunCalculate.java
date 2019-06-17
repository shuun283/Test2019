package rin.lesson3.calculate;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RunCalculate {

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
		String targetStr = "00999+12-12*2/6";
		char[] chars = targetStr.toCharArray();
		try {
			List<Token> tokenList = analysisExpression(chars);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		double result = doCalcute(ope, num1, num2);
//		System.out.println(result);
	}

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
					idx = strOpe.length()-1;
					break;
//				case '(':
//				case ')':
//					//TODO
//					break;
				default:
					if(isDigit(c)){
						String strNumeric = getNumeric(chars, idx);
						Token tokenNumeric = new TokenNumeric(strNumeric);
						tokenList.add(tokenNumeric);
						idx = strNumeric.length()-1;
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
	 * @param c
	 * @return
	 */
	private static boolean isOpe(char c) {
		if(c == '+' || c == '-' || c == '*' || c == '/'){
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param c
	 * @return
	 */
	private static boolean isDigit(char c) {
		if('0'<=c && c<='9'){
			return true;
		}
		return false;
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
			char c = chars[idx];
			if(isOpe(c)){
				sb.append(c);
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
			char c = chars[idx];
			if(isDigit(c)){
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 * 加算機【四則演算】
	 * @param targetStr
	 * @return
	 * @throws Exception 
	 */
	public static List<String> changeExpressionToInfix(List<Token> tokenList) throws Exception {
		Stack<String> middle = new Stack<String>();
		Token tokenLeft = null;
		for(Token token : tokenList){
			if(tokenLeft !=null && token.isOperator()){
				if(tokenLeft.isPriorityHigherThan(token)>0){
					
				}
			}
			tokenLeft = token;
		}
		return middle;
	}//Postfix

	/**
	 * 加算機【四則演算】
	 * @param targetStr
	 * @return
	 * @throws Exception 
	 */
	public static double doCalcute(char ope, double num1, double num2) throws Exception {
		double result = 0d;

		switch (ope){
			case '+':
				result =  num1 + num2;
				break;
			case '-':
				result = num1 + num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				if(num2 == 0){
					//TODO
				}
				result = num1 / num2;
				break;
			default:
				throw new Exception("無効演算子");
		}
		return result;
	}
}
