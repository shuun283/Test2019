package ou.cal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Calculate {

	public static String parse(String src) {
		try {
			// 1.split
			List<String> srcList = analysis(src);
			// 2.remove brackets
			ArrayList<String> srcList2 = removeBrackets(srcList.toArray(new String[srcList.size()]));
			// 3.calculate
			String result = execute(srcList2);

			return result;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	private static List<String> analysis(String src) {
		src = src.replace(" ", "");
		int len = src.length();
		List<String> result = new ArrayList<String>();
		StringBuilder number = new StringBuilder();
		for (int i = 0; i < len; i++) {
			char b = src.charAt(i);
			if (b == '-') {
				if (i == 0) {
					number.append(b);
				} else {
					if (src.charAt(i - 1) == '(') {
						number.append(b);
					}else if (src.charAt(i + 1) == '(') {
						result.add(number.toString());
						result.add("-");
						number.setLength(0);
					} else {
						if (number.length() > 0) {
							result.add( number.toString());
							number.setLength(0);
							number.append('-');
						}
						result.add("+");
					}
				}
			} else if (b == '+' || b == '*' || b == '/' || b == '(' || b == ')') {
				if (number.length() > 0) {
					result.add(number.toString());
					number.setLength(0);
				}
				result.add(String.valueOf(b));
			} else {
				number.append(b);
				if (i == len - 1) {
					result.add(number.toString());
				}
			}
		}

		return result;
	}

	private static ArrayList<String> removeBrackets(String[] srcList) {
		Stack<String> stack = new Stack<String>();

		// Remove the brackets
		for (int i = 0; i < srcList.length; i++) {
			String cell = srcList[i];
			if (")".equals(cell)) {
				ArrayList<String> tmpArray = new ArrayList<String>();
				while (!"(".equals(stack.peek())) {
					tmpArray.add(stack.pop());
				}
				stack.pop();
				Collections.reverse(tmpArray);
				String unit = execute(tmpArray);
				stack.push(unit);
			} else {
				stack.push(cell);
			}
		}

		ArrayList<String> srcList2 = new ArrayList<String>(stack);
		return srcList2;
	}

	private static String execute(List<String> srcList) {

		Stack<String> stack = new Stack<String>();

		// Mul & Div
		for (int i = 0; i < srcList.size(); i++) {
			String cell = srcList.get(i);
			double item;
			switch (cell) {
			case "*":
				item = Double.valueOf(stack.pop()) * Double.valueOf(srcList.get(1 + i++));
				stack.push(String.valueOf(item));
				break;
			case "/":
				item = Double.valueOf(stack.pop()) / Double.valueOf(srcList.get(1 + i++));
				stack.push(String.valueOf(item));
				break;
			default:
				stack.push(cell);
				break;
			}
		}

		while (stack.size() > 1) {
			double num1 = Double.valueOf(stack.pop());
			String op = stack.pop();
			double num2 = Double.valueOf(stack.pop());
			double item;
			switch (op) {
			case "+":
				item = num2 + num1;
				stack.push(String.valueOf(item));
				break;
			case "-":
				item = num2 - num1;
				stack.push(String.valueOf(item));
				break;
			default:

				break;
			}
		}

		return stack.pop();
	}
}
