package rin.lesson4.calculate;

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
//		expressionList.add("");
//		expressionList.add(" ");//
//		expressionList.add("12,345");//
//		expressionList.add("12,345.6");//
//		expressionList.add("12,345.6-2");//
//		expressionList.add(")(");//
//		expressionList.add("((2+4)");//
//		expressionList.add("24+12-+4)");//
//		expressionList.add("9+8/7(6-5)/4-3*2");// error
//		expressionList.add("9+8/-7(6-5)/4-3*2");// error
		
//		expressionList.add("1+2*3-4/5");// 6.2
//		expressionList.add("123+456*22");// 10155
//		expressionList.add("12*(3+4)*22");// 1848
//		expressionList.add("(1+5)*3-4/2");
//		expressionList.add("1+5*3-4/2");
//		expressionList.add("1+50/2*(7-3)");// 101
//		expressionList.add("1+50/2*(7-3)/2-5*6");// 21
//		expressionList.add("1+50/2*(7-3)*(3*(15+5))/2-5*6");// 2971
//		expressionList.add("-50+2");// -48.0
//		expressionList.add("-2*15");// -30.0
//		expressionList.add("9+8/(-7)*(6-5)/4-3*2");// 9 8 -7 / 6 5 - * 4 / + 3 2 * -         2.714285714285714
//		expressionList.add("9+8/7*(6-5)/4-3*2");// 9 8 7 / 6 5 - * 4 / + 3 2 * -             3.2857142857142865
//		expressionList.add("9+8/7*(6-5)*(4*(3+2))/1-9*8");// 9 8 7 / 6 5 - * 4 3 2 + * * 1 / + 9 8 * -      -40.142857142857146

		int i = 1;
		for(String exp: expressionList) {
			try {
				System.out.print((i++)+"行目：");
				doExcute(exp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static void doExcute(String exp) throws Exception {
		System.out.println("\r\n***************元式：");
		char[] chars = exp.toCharArray();
		List<Token> firstExpList = Partical.analysisExpression(chars);
		for (Token token : firstExpList) {
			System.out.print(token.toString());
		}
		System.out.println("\r\n***************後置式：");
		List<Token> middleExpList = Change.getPostfixFromInfix(firstExpList);
//		for (Token token : middleExpList) {
//			System.out.print(token.toString()+" ");
//		}
		System.out.println("\r\n***************計算結果：");
		System.out.println(Calculate.calcutePostfixExpression(middleExpList));
	}

}
