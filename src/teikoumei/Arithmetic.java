package teikoumei;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Arithmetic extends Arithm implements ArithmeticIF {
	
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
			String data = String.valueOf(c);
			switch (c) {
			case '+':
			case '*':
			case '/':
				if (operator.length() > 0) {
					setLength(resultList, operator);
				}
				resultList.add(data);
				break;
			case '-':
				if (i == 0 && (c) == '-') {
					operator.append(c);
				} else {
					if (operator.length() > 0) {
						setLength(resultList, operator);
					}
					resultList.add(data);
				}
				break;
			case ' ':
				continue;
			default:
				if (!isNumber(c)) {
					throw new Exception(Constants.FOUR_ARITHMETIC_ERROR + "     " + "エラー位置: " + i);
				} else {
					operator.append(c);
				}
			}
		}
		if (operator.length() > 0) {
			resultList.add(operator.toString());
		}
		return resultList;
	}

	private List<String> RPNList(List<String> list) {
		List<String> result = new ArrayList<String>();
		Stack<String> stackResult = new Stack<String>();
		String tmp;
		for (String l : list) {
			if (l.equals("*") || l.equals("/")) {
				while (!stackResult.isEmpty()) {
					tmp = stackResult.peek();
					if (tmp.equals("*") || tmp.equals("/")) {
						stackResult.pop();
						result.add(tmp);
					} else {
						break;
					}
				}
				stackResult.push(l);
			} else if (l.equals("+") || l.equals("-")) {
				while (!stackResult.isEmpty()) {
					tmp = stackResult.peek();
					stackResult.pop();
					result.add(tmp);
				}
				stackResult.push(l);
			} else {
				result.add(l);
			}
		}
		while (!stackResult.isEmpty()) {
			result.add(stackResult.pop());
		}
		return result;
	}

	private double RPNCalculation(List<String> list) throws Exception {
		Stack<Double> resultStack = new Stack<Double>();
		Double num1;
		Double num2;
		double resultNum;
		for (String item : list) {
			if (isOperator(item)) {
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
