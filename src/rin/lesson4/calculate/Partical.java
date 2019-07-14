package rin.lesson4.calculate;

import java.util.ArrayList;
import java.util.List;

public class Partical {

	private static Integer parenNum =0;
	private static Integer rullerNum =0;
	private static final int INT_ADD = 1;
	private static final int INT_MINUS = -1;
	
	/**
	 * 解析にて、演算式を取得する
	 * 
	 * @param chars
	 * @return
	 * @throws Exception
	 */
	public static List<Token> analysisExpression(char[] chars) throws Exception {
		List<Token> tokenList = new ArrayList<Token>();
		Token tokenBefore = null;
		for (int idx = 0; idx < chars.length; idx++) {
			char c = chars[idx];
			if (c == ' ' || c == '　') {
				continue;
			}

			Token token = null;
			switch (c) {
			case '+':
				token = new TokenAdd(c);
				checkOperatorsMarch(INT_MINUS, idx);
				break;
			case '-':
				if (idx == 0 || !TokenType.NUMERIC.equals(tokenBefore.getNoteType())) {//オペランドとして
					String strNumeric = getNumeric(chars, idx);
					idx = idx + strNumeric.length() - 1;
					token = new TokenNumeric(strNumeric);
					checkOperatorsMarch(INT_ADD, idx);
				} else {//オペレータとして
					token = new TokenMinus(c);
					checkOperatorsMarch(INT_MINUS, idx);
				}
				break;
			case '*':
				token = new TokenMultiply(c);
				checkOperatorsMarch(INT_MINUS, idx);
				break;
			case '/':
				token = new TokenDivide(c);
				checkOperatorsMarch(INT_MINUS, idx);
				break;
			case '(':
				token = new TokenParenOpen(c);
				checkParensMarch(INT_ADD, idx);
				break;
			case ')':
				token = new TokenParenClose(c);
				checkParensMarch(INT_MINUS, idx);
				break;
			default:
				if (CommonUtil.isDigit(c)) {
					String strNumeric = getNumeric(chars, idx);
					idx = idx + strNumeric.length() - 1;
					token = new TokenNumeric(strNumeric);
					checkOperatorsMarch(INT_ADD, idx);
					break;
				} else {
					throw new Exception("無効文字です。そのインデックスは" + (idx + 1));
				}
			}
			tokenList.add(token);
			tokenBefore = token;
		}
		if(rullerNum!=1) {
			throw new Exception("最後の演算符号がミスマッチです。");
		}
		if(parenNum!=0) {
			throw new Exception("最初か最後の括弧がミスマッチです。");
		}
		return tokenList;
	}

	/**
	 * 演算式の成り立つルールを違反したかチェック【その演算符号部分】
	 * @param transNum 遷移量
	 * @param idx 文字のインデックス
	 * @throws Exception
	 */
	private static void checkOperatorsMarch(int transNum, int idx) throws Exception {
		rullerNum+=transNum;
		if(rullerNum<0 || rullerNum>1) {
			throw new Exception("演算符号がミスマッチです。そのインデックスは" + (idx + 1));
		}
	}

	/**
	 * 演算式の成り立つルールを違反したかチェック【その括弧部分】
	 * @param transNum 遷移量
	 * @param idx 文字のインデックス
	 * @throws Exception
	 */
	private static void checkParensMarch(int transNum, int idx) throws Exception {
		parenNum+=transNum;
		if(parenNum<0) {
			throw new Exception("括弧がミスマッチです。" + (idx + 1));
		}
	}

	/**
	 * 演算子単位で取得
	 * 
	 * @param chars
	 * @param idx
	 * @return
	 */
	private static String getNumeric(char[] chars, int idx) {
		StringBuilder sb = new StringBuilder();
		sb.append(chars[idx]);
		for (int i = idx + 1; i < chars.length; i++) {
			char c = chars[i];
			if (CommonUtil.isDigit(c)) {
				sb.append(c);
			} else {
				break;
			}
		}
		return sb.toString();
	}
}
