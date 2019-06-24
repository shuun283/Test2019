package rin.calculate;

import java.util.List;

public class RunCalculate {

	/**
	 * 四則演算する
	 * @param args
	 */
	public static void main(String[] args) {
		String targetStr = "1+5*3-4/2";
		char[] chars = targetStr.toCharArray();
		try {
			List<Token> firstExpList = Partical.analysisExpression(chars);
			for (Token token : firstExpList) {
				System.out.print(token.toString());
			}
			System.out.println();
			List<Token> middleExpList = Change.changeInfixExpressionToPostfix(firstExpList);
			for (Token token : middleExpList) {
				System.out.print(token.toString());
			}
			System.out.println();
			System.out.print(Calculate.calcutePostfixExpression(middleExpList));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
