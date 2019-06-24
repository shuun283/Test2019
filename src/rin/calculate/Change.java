package rin.calculate;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Change {

	/**
	 * 中置式から後置式へ
	 * @param tokenList
	 * @return
	 * @throws Exception
	 */
	public static List<Token> changeInfixExpressionToPostfix(List<Token> tokenList) throws Exception {
		List<Token> middleExpList = new ArrayList<Token>();
		Stack<Token> opeStack = new Stack<Token>();
		for (Token token : tokenList) {
			if (TokenType.NUMERIC.equals(token.getNoteType())) {
				middleExpList.add(token);
				break;
			}
			while (!opeStack.isEmpty()) {
				if (token.isPriorityHigherThan(opeStack.peek()) <= 0) {// 循環する
					middleExpList.add(opeStack.pop());
				} else {
					opeStack.push(token);
					break;
				}
			}
		}
		while (!opeStack.isEmpty()) {
			middleExpList.add(opeStack.pop());
		}
		return middleExpList;
	}
}
