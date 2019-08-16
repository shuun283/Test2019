package rin.calculate;

import java.util.List;
import java.util.Stack;

public class CalculateUtil {

	private CalculateUtil() {
	}

	/**
	 * 計算する
	 * 
	 * @param postfixTokenList
	 * @return
	 * @throws CalcuteException
	 */
	public static double calcutePostfixExp(final List<Token> postfixTokenList) throws CalcuteException {
		Stack<Double> numStack = new Stack<Double>();
		for (Token token : postfixTokenList) {
			if (TokenType.NUMERIC.equals(token.getNodeType())) {
				numStack.push(((TokenNumeric) token).getDoubleValue());
			} else {
				numStack.push(doCalcute(token, numStack));
			}
		}
		return numStack.pop();
	}

	/**
	 * 四則演算
	 * 
	 * @param operator
	 * @param numStack
	 * @return
	 * @throws CalcuteException
	 */
	private static double doCalcute(final Token operator, final Stack<Double> numStack) throws CalcuteException {
		double result = 0d;
		double num2 = numStack.pop();
		double num1 = numStack.pop();

		switch (operator.getNodeType()) {
			case ADD:
				result = num1 + num2;
				break;
			case MINUS:
				result = num1 - num2;
				break;
			case MULTIPLY:
				result = num1 * num2;
				break;
			case DIVIDE:
				if (num2 == 0) {
					throw new CalcuteException("除0エラー");
				}
				result = num1 / num2;
				break;
			default:
				throw new CalcuteException("無効演算子");
		}
		return result;
	}
}
