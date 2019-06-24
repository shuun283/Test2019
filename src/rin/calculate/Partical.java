package rin.calculate;

import java.util.ArrayList;
import java.util.List;

public class Partical {

	/**
	 * 解析にて、演算式を取得する
	 * 
	 * @param chars
	 * @return
	 * @throws Exception
	 */
	public static List<Token> analysisExpression(char[] chars) throws Exception {
		List<Token> tokenList = new ArrayList<Token>();
		for (int idx = 0; idx < chars.length; idx++) {
			char c = chars[idx];
			if (c == ' ' || c == '　') {
				continue;
			}

			Token token = null;
			switch (c) {
			case '+':
				token = new TokenAdd(c);
				idx++;
				break;
			case '-':
				token = new TokenMinus(c);
				idx++;
				break;
			case '*':
				token = new TokenMultiply(c);
				idx++;
				break;
			case '/':
				token = new TokenDivide(c);
				idx++;
				break;
			case '(':
				token = new TokenParrenLeft(c);
				idx++;
				break;
			case ')':
				token = new TokenParrenRight(c);
				idx++;
				break;
			default:
				if (CommonUtil.isDigit(c)) {
					String strNumeric = getNumeric(chars, idx);
					idx = idx + strNumeric.length() - 1;
					token = new TokenNumeric(strNumeric);
					break;
				} else {
					throw new Exception("無効文字です。そのインデックスは" + (idx + 1));
				}
			}
			tokenList.add(token);
		}
		return tokenList;
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
