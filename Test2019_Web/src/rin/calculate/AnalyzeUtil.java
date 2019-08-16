package rin.calculate;

import java.util.ArrayList;
import java.util.List;

public class AnalyzeUtil {

	private AnalyzeUtil() {
	}

	/**
	 * 解析にて、演算式を取得する
	 * 
	 * @param chars
	 * @return
	 * @throws CalcuteException 
	 */
	public static List<Token> analyzeExpression(final char[] chars) throws CalcuteException{
		int parenNum = 0;
		int rullerNum = 0;
		List<Token> tokenList = new ArrayList<Token>();
		Token tokenBefore = null;
		for (int idx = 0; idx < chars.length; idx++) {
			char c = chars[idx];
			if (c == ' ' || c == '	') {// half space AND tab IS VALID;
				continue;
			}

			Token token = null;
			switch (c) {
				case '+':
					token = new TokenOperator(TokenType.ADD);
					rullerNum--;
					break;
				case '-':
					if (tokenBefore != null
							&& (TokenType.PAREN_CLOSE.equals(tokenBefore.getNodeType()) || TokenType.NUMERIC.equals(tokenBefore.getNodeType()))) {// オペレータとして
						token = new TokenOperator(TokenType.MINUS);
						rullerNum--;
					} else {// オペランドとして
						String strNumeric = getNumeric(chars, idx);
						idx = idx + strNumeric.length() - 1;
						token = new TokenNumeric(strNumeric);
						rullerNum++;
					}
					break;
				case '*':
					token = new TokenOperator(TokenType.MULTIPLY);
					rullerNum--;
					break;
				case '/':
					token = new TokenOperator(TokenType.DIVIDE);
					rullerNum--;
					break;
				case '(':
					token = new TokenOperator(TokenType.PAREN_OPEN);
					parenNum++;
					break;
				case ')':
					token = new TokenOperator(TokenType.PAREN_CLOSE);
					parenNum--;
					if (parenNum < 0) {
						throw new CalcuteException("括弧がミスマッチです。" + (idx + 1));
					}
					break;
				default:
					if (isDigit(c)) {
						String strNumeric = getNumeric(chars, idx);
						idx = idx + strNumeric.length() - 1;
						token = new TokenNumeric(strNumeric);
						rullerNum++;
						break;
					} else {
						// full_space もエラー
						throw new CalcuteException("無効文字です。そのインデックスは" + (idx + 1));
					}
			}
			if (rullerNum < 0 || rullerNum > 1) {
				throw new CalcuteException("演算符号がミスマッチです。そのインデックスは" + (idx + 1));
			}
			tokenList.add(token);
			tokenBefore = token;
		}
		if (rullerNum != 1) {
			throw new CalcuteException("最後の演算符号がミスマッチです。");
		}
		if (parenNum != 0) {
			throw new CalcuteException("最初か最後の括弧がミスマッチです。");
		}
		return tokenList;
	}

	/**
	 * 演算子単位で取得
	 * 
	 * @param chars 丸演算式
	 * @param idx   operant単位の開始インデックス
	 * @return
	 */
	private static String getNumeric(final char[] chars, final int idx) {
		StringBuilder sb = new StringBuilder();
		sb.append(chars[idx]);
		// boolean isPointfound=false;
		for (int i = idx + 1; i < chars.length; i++) {
			char c = chars[i];
			if (isDigit(c) || c == '.') {
				sb.append(c);
			} else {
				break;
			}
		}
		return sb.toString();
	}

	/**
	 * 数値の判断
	 * 
	 * @param c
	 * @return
	 */
	private static boolean isDigit(final char c) {
		if ('0' <= c && c <= '9') {
			return true;
		}
		return false;
	}

}
