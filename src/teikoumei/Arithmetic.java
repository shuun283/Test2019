package teikoumei;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 鄭 光明
 *
 */
public class Arithmetic implements ArithmeticIF {

	public void Operation(String arithmeticData) throws Exception {
		Arithmetic arithmetic = new Arithmetic();
		List<String> list = arithmetic.listArithmetic(arithmeticData);
		List<String> list2 = arithmetic.RPNList(list);
		double result = arithmetic.RPNCalculation(list2);
		System.out.println("結果:   " + result);
	}

	private List<String> listArithmetic(String arithmeticData) throws Exception {
		List<String> resultList = new ArrayList<String>();
		char arithmeticDataArray[] = arithmeticData.toCharArray();
		StringBuilder operator = new StringBuilder();
		for (int i = 0; i < arithmeticDataArray.length; i++) {
			char c = arithmeticDataArray[i];
			// C：数値の場合
			if (Common.isNumber(c)) {
				operator.append(c);
				continue;
			} else if (operator.length() > 0) {
				resultList.add(operator.toString());
				operator.setLength(0);
			}
			String data = String.valueOf(c);
			switch (c) {
			case '+':
			case '*':
			case '/':
			case '(':
			case ')':
				resultList.add(data);
				break;
			case '-':
				if (i == 0) {
					operator.append(c);
				} else {
					resultList.add(data);
				}
				break;
			case ' ':
				continue;
			default:
				throw new Exception(Constants.FOUR_ARITHMETIC_ERROR + "     " + "エラー位置: " + i);
			}
		}
		if (operator.length() > 0) {
			resultList.add(operator.toString());
		}
		return resultList;
	}

	/**
	 * @param list
	 * @return
	 */
	private List<String> RPNList(List<String> list) {
		List<String> resultList = new ArrayList<String>();
		Stack<String> stack = new Stack<String>();// スタックで数学演算子を格納される

		for (String item : list) {
			// 数値の場合は、リストに直接格納されている。
			if (!Common.isOperator(item)) {
				resultList.add(item);
			} else {
				switch (item) {
				case "+":
				case "-":
					if (!stack.empty() && (!stack.peek().equals("("))) {
						resultList.add(stack.pop());
					}
					stack.push(item);
					break;
				case "*":
				case "/":
					if (!stack.empty() && (stack.peek().equals("*") || stack.peek().equals("/"))) {
						resultList.add(stack.pop());
					}
					stack.push(item);
					break;
				case "(":
					stack.push(item);
					break;
				case ")":
					while (!stack.empty() && (!stack.peek().equals("("))) {
						resultList.add(stack.pop());
					}
					stack.pop();
					break;
				}
			}
		}
		while (!stack.empty()) {
			resultList.add(stack.pop());
		}
		return resultList;
	}

	/**
	 * 計算
	 * 
	 * @param list
	 * @return
	 * @throws Exception
	 */
	private double RPNCalculation(List<String> list) throws Exception {
		Stack<Double> resultStack = new Stack<Double>();
		Double num1;
		Double num2;
		double resultNum;
		for (String item : list) {
			if (Common.isOperator(item)) {
				num2 = resultStack.pop();
				num1 = resultStack.pop();
				switch (item) {
				case "+":
					resultNum = num1 + num2;
					resultStack.push(resultNum);
					break;
				case "-":
					resultNum = num1 - num2;
					resultStack.push(resultNum);
					break;
				case "*":
					resultNum = num1 * num2;
					resultStack.push(resultNum);
					break;
				case "/":
					if (num2 == 0) {
						throw new Exception(Constants.DENOMINATOR_EXCEPTION);
					}
					resultNum = num1 / num2;
					resultStack.push(resultNum);
					break;
				default:
					break;
				}
			} else {
				resultStack.push(Double.parseDouble(item));
			}
		}
		return resultStack.pop();
	}
}
