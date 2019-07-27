package rin.lesson5IO.calculate;

import java.util.ArrayList;
import java.util.List;

public class RunCalculate {

	/**
	 * 四則演算する
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> expressionList = new ArrayList<String>();
		//TODO:testパターンを洗い出す
		expressionList.add("　");// error
		expressionList.add(")(");// error
		expressionList.add("12,345");// error
		expressionList.add("((2+4)");// error
		expressionList.add("24+12-+4)");// error
		expressionList.add("9+8/7(6-5)/4-3*2");// error
		expressionList.add("9+8/-7(6-5)/4-3*2");// error

		expressionList.add(" ");//
		expressionList.add("	");//
		expressionList.add("123+456*22");// 10155
		expressionList.add("12*(3+4)*22");// 1848
		expressionList.add(" 1+3*5-4/2");  //-14
		expressionList.add(" -6-(-1.5+5)*3-4/2");  //-18.5
		expressionList.add("1+50/2*(7-3*2+3)-5*6");// 71
		expressionList.add("1+50/2*(7-3)*(3*(15+5))/2-5*6");// 2971
		expressionList.add("9+8/(-7)*(6-5)/4-3*2");// 9 8 -7 / 6 5 - * 4 / + 3 2 * -         2.714285714285714
		expressionList.add("9+8/7*(6-5)/4-3*2");// 9 8 7 / 6 5 - * 4 / + 3 2 * -             3.2857142857142865
		expressionList.add("9+8/7*(6-5)*(4*(3+2))/1-9*8");// 9 8 7 / 6 5 - * 4 3 2 + * * 1 / + 9 8 * -      -40.142857142857146

		int i = 1;
		for (String exp : expressionList) {
			try {
				System.out.print((i++) + "行目："+exp);
				doExcute(exp);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static void doExcute(final String exp) throws Exception {
		System.out.print("\r\n\t***************元式：");
		char[] chars = exp.toCharArray();
		List<Token> firstExpList = Partical.analysisExpression(chars);
		for (Token token : firstExpList) {
			System.out.print(token.getStringValue()+" ");
		}
		System.out.print("\r\n\t***************後置式：");
		List<Token> middleExpList = Change.getPostfixFromInfix(firstExpList);
		for (Token token : middleExpList) {
			System.out.print(token.getStringValue()+" ");
		}
		System.out.print("\r\n\t******************************計算結果：");
		System.out.println(Calculate.calcutePostfixExpression(middleExpList));
	}

}
