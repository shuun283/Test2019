package shou.calculator;

import java.util.List;
import java.util.Stack;

public class Calculator {

	/**
	 * 加算メソッド
	 * 
	 * @param List<Token>
	 * @return double
	 */
	public double calculate(final List<Token> tokens) {
		Stack<Double> s = new Stack<Double>();
		System.out.println(tokens);
		tokens.forEach(t -> {
			if (t.getPriority() == -3) {
				// 数字の場合
				s.push(((Digital) t).getValue());
			} else {
				// 演算子の場合
				s.push(t.calculate(s.pop(), s.pop()));
			}
		});
		return s.pop();
	}
}
