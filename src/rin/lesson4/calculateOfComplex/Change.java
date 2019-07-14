package rin.lesson4.calculateOfComplex;

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
	public static List<Token> getPostfixFromInfix(List<Token> tokenList) throws Exception {
		List<Token> middleExpList = new ArrayList<Token>();
		Stack<Token> opeStack = new Stack<Token>();
		boolean isParenOpen = false;
		for (Token token : tokenList) {
			switch(token.getNoteType()) {
				case PAREN_OPEN:
					isParenOpen = true;
					opeStack.push(token);
					break;
				case PAREN_CLOSE:
					pogOperatorsUntilParenLeft(middleExpList, opeStack);
					isParenOpen = false;
					break;
				case NUMERIC:
					System.out.print(token.getNote()+" ");
					middleExpList.add(token);
					break;
				default:
					if (isParenOpen) {
						opeStack.push(token);
						break;
					}
					if (!opeStack.isEmpty() && !token.isPriorityHighterThan(opeStack.peek())) {// 循環する
						pogOperatorsUntilLowerPriority(middleExpList, opeStack, token);
					}
					opeStack.push(token);
					break;
			}
		}
		while (!opeStack.isEmpty()) {
			System.out.print(opeStack.peek().getNote()+" ");
			middleExpList.add(opeStack.pop());
		}
		return middleExpList;
	}

	/**
	 * 左括弧と遭遇するまで演算符号をPOPする
	 * @param middleExpList
	 * @param opeStack
	 */
	private static void pogOperatorsUntilParenLeft(List<Token> middleExpList, Stack<Token> opeStack) {
		while (!opeStack.isEmpty()) {
			if(TokenType.PAREN_OPEN.equals(opeStack.peek().getNoteType() )){
				opeStack.pop();
				break;
			}
			System.out.print(opeStack.peek().getNote()+" ");
			middleExpList.add(opeStack.pop());
		}
	}

	/**
	 * より優先度低いデータと遭遇するまで演算符号をPOPする
	 * @param middleExpList
	 * @param opeStack
	 * @param token
	 */
	private static void pogOperatorsUntilLowerPriority(List<Token> middleExpList, Stack<Token> opeStack, Token token) {
		while (!opeStack.isEmpty()) {
			if (token.isPriorityHighterThan(opeStack.peek())) {
				break;
			}
			System.out.print(opeStack.peek().getNote()+" ");
			middleExpList.add(opeStack.pop());
		}
	}
}
	