package rin.lesson3.calculate;

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
			if (token.isNumeric()) {
				middleExpList.add(token);
			} else {
				if (opeStack.isEmpty()) {
					opeStack.push(token);
				} else if (token.isPriorityHigherThan(opeStack.peek()) > 0) {
					opeStack.push(token);
				} else {
					doPopOpeStack(token, opeStack, middleExpList);
					opeStack.push(token);
				}
			}
		}
		doPopOpeStack(null, opeStack, middleExpList);
		return middleExpList;
	}

	/**
	 * オペレータのPOP
	 * @param token
	 * @param opeStack
	 * @param middleExpList
	 */
	private static void doPopOpeStack(Token token, Stack<Token> opeStack, List<Token> middleExpList) {
		while (!opeStack.isEmpty()) {
			if (token == null || token.isPriorityHigherThan(opeStack.peek()) <= 0) {
				middleExpList.add(opeStack.pop());
			}
		}
	}
}
