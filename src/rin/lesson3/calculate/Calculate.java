package rin.lesson3.calculate;

import java.util.List;
import java.util.Stack;

public class Calculate {

	/**
	 * 加算機【四則演算】
	 * 
	 * @param targetStr
	 * @return
	 * @throws Exception
	 */
	public static double calcutePostfixExpression(List<Token> tokenList) throws Exception {
		double result = 0d;
		Stack<Double> numStack = new Stack<Double>();
		double num1;
		double num2;
		for (Token token : tokenList) {
			if (token.isNumeric()) {
				numStack.push(((TokenNumeric) token).getDoubleValue());
				continue;
			} else {
				num2 = numStack.pop();
				num1 = numStack.pop();
				numStack.push(doCalcute(token.toString(), num1, num2));
			}
		}
		return numStack.pop();
	}

	/**
	 * 加算機【四則演算】
	 * 
	 * @param targetStr
	 * @return
	 * @throws Exception
	 */
	public static double doCalcute(String ope, double num1, double num2) throws Exception {
		double result = 0d;

		switch (ope) {
		case "+":
			result = num1 + num2;
			break;
		case "-":
			result = num1 - num2;
			break;
		case "*":
			result = num1 * num2;
			break;
		case "/":
			if (num2 == 0) {
				// TODO
			}
			result = num1 / num2;
			break;
		default:
//			throw new Exception("無効演算子");
		}
		return result;
	}
}
