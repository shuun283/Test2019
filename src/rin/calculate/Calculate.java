package rin.calculate;

import java.util.List;
import java.util.Stack;

public class Calculate {

	/**
	 * 計算する
	 * @param tokenList
	 * @return
	 * @throws Exception
	 */
	public static double calcutePostfixExpression(List<Token> tokenList) throws Exception {
		Stack<Double> numStack = new Stack<Double>();
		for (Token token : tokenList) {
			if (TokenType.NUMERIC.equals(token.getNoteType())) {
				numStack.push(((TokenNumeric) token).getDoubleValue());
				continue;
			} else {
				numStack.push(doCalcute(token, numStack));
			}
		}
		return numStack.pop();
	}

	/**
	 * 四則演算
	 * @param operator
	 * @param numStack
	 * @return
	 * @throws Exception
	 */
	public static double doCalcute(Token operator, Stack<Double> numStack) throws Exception {
		double result = 0d;
		double num2 = numStack.pop();
		double num1 = numStack.pop();

		switch (operator.getNoteType()) {
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
				throw new Exception("除0エラー");
			}
			result = num1 / num2;
			break;
		default:
			throw new Exception("無効演算子");
		}
		return result;
	}
}
