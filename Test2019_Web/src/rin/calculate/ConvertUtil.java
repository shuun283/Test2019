package rin.calculate;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ConvertUtil {

	private ConvertUtil() {
	}

	/**
	 * 中置式から後置式へ(Infix→Postfix)
	 * 
	 * @param tokenListFrom
	 * @return
	 */
	public static List<Token> toPostfixList(final List<Token> tokenListFrom) {
		List<Token> tokenListTo = new ArrayList<Token>();
		Stack<Token> tmpStack = new Stack<Token>();
		for (Token token : tokenListFrom) {
			if (token.getNoteType() == TokenType.PAREN_CLOSE) {
				popOperatorsUntilParenLeft(tmpStack, tokenListTo);
			} else {
				popOrPushOperators(tmpStack, tokenListTo, token);
			}
		}
		while (!tmpStack.isEmpty()) {
			tokenListTo.add(tmpStack.pop());
		}
		return tokenListTo;
	}

	/**
	 * 左括弧と遭遇するまで演算符号をPOPする
	 * 
	 * @param tokenListTo
	 * @param tmpStack
	 */
	private static void popOperatorsUntilParenLeft(final Stack<Token> tmpStack, final List<Token> tokenListTo) {
		while (!tmpStack.isEmpty()) {
			if (TokenType.PAREN_OPEN.equals(tmpStack.peek().getNoteType())) {
				tmpStack.pop();
				break;
			}
			tokenListTo.add(tmpStack.pop());
		}
	}

	/**
	 * より優先度低いデータと遭遇するまで演算符号をPOPする
	 * 
	 * @param tokenListTo
	 * @param tmpStack
	 * @param token
	 */
	private static void popOrPushOperators(Stack<Token> tmpStack, List<Token> tokenListTo, final Token token) {

		while (!tmpStack.isEmpty()) {
			int isPopResult = tmpStack.peek().chkIspopWith(token);
			if (isPopResult == 1) {
				tokenListTo.add(tmpStack.pop());
			} else if (isPopResult == -1) {
				tmpStack.push(token);
				break;
			} else {
				break;
			}
		}
		if (tmpStack.isEmpty()) {
			tmpStack.push(token);
			return;
		}
	}
}
