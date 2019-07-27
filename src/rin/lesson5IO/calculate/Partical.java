package rin.lesson5IO.calculate;

import java.util.ArrayList;
import java.util.List;

public class Partical {

	private static final int ADD_ONE = 1;
	private static final int MINUS_ONE = -1;

	/**
	 * 解析にて、演算式を取得する
	 * 
	 * @param chars
	 * @return
	 * @throws Exception
	 */
	public static List<Token> analysisExpression(final char[] chars) throws Exception {
		Integer parenNum = 0;
		Integer rullerNum = 0;
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
					rullerNum = chkOperatorsMarch(rullerNum, MINUS_ONE, idx);
					break;
				case '-':
					if (tokenBefore != null &&
					(TokenType.PAREN_CLOSE.equals(tokenBefore.getNoteType()) || TokenType.NUMERIC.equals(tokenBefore.getNoteType()))) {// オペレータとして
						token = new TokenOperator(TokenType.MINUS);
						rullerNum = chkOperatorsMarch(rullerNum, MINUS_ONE, idx);
					} else {// オペランドとして
						String strNumeric = getNumeric(chars, idx);
						idx = idx + strNumeric.length() - 1;
						token = new TokenNumeric(strNumeric);
						rullerNum = chkOperatorsMarch(rullerNum, ADD_ONE, idx);
					}
					break;
				case '*':
					token = new TokenOperator(TokenType.MULTIPLY);
					rullerNum = chkOperatorsMarch(rullerNum, MINUS_ONE, idx);
					break;
				case '/':
					token = new TokenOperator(TokenType.DIVIDE);
					rullerNum = chkOperatorsMarch(rullerNum, MINUS_ONE, idx);
					break;
				case '(':
					token = new TokenOperator(TokenType.PAREN_OPEN);
					parenNum++;
					break;
				case ')':
					token = new TokenOperator(TokenType.PAREN_CLOSE);
					parenNum = chkParensMarch(parenNum, MINUS_ONE, idx);
					break;
				default:
					if (CommonUtil.isDigit(c)) {
						String strNumeric = getNumeric(chars, idx);
						idx = idx + strNumeric.length() - 1;
						token = new TokenNumeric(strNumeric);
						rullerNum = chkOperatorsMarch(rullerNum, ADD_ONE, idx);
						break;
					} else {
						// full_space もエラー
						throw new Exception("無効文字です。そのインデックスは" + (idx + 1));
					}
			}
			tokenList.add(token);
			tokenBefore = token;
		}
		if (rullerNum != 1) {
			throw new Exception("最後の演算符号がミスマッチです。");
		}
		if (parenNum != 0) {
			throw new Exception("最初か最後の括弧がミスマッチです。");
		}
		return tokenList;
	}

	/**
	 * 演算式の成り立つルールを違反したかチェック【その演算符号部分】
	 * 
	 * @param rullerNum 括弧以外NODEの増減結果【数値は＋1；オペレータは-1】
	 * @param transNum  遷移量
	 * @param idx       文字のインデックス
	 * @throws Exception
	 */
	private static int chkOperatorsMarch(final int rullerNum, final int transNum, final int idx) throws Exception {
		int ruller_num_result = rullerNum + transNum;
		if (ruller_num_result < 0 || ruller_num_result > 1) {
			throw new Exception("演算符号がミスマッチです。そのインデックスは" + (idx + 1));
		}
		return ruller_num_result;
	}

	/**
	 * 演算式の成り立つルールを違反したかチェック【その括弧部分】
	 * 
	 * @param parenNum 括弧増減結果
	 * @param transNum 遷移量
	 * @param idx      文字のインデックス
	 * @throws Exception
	 */
	private static int chkParensMarch(final int parenNum, final int transNum, final int idx) throws Exception {
		int paren_num_result = parenNum + transNum;
		if (paren_num_result < 0) {
			throw new Exception("括弧がミスマッチです。" + (idx + 1));
		}
		return paren_num_result;
	}

	/**
	 * 演算子単位で取得
	 * 
	 * @param chars 丸演算式
	 * @param idx operant単位の開始インデックス
	 * @return
	 */
	private static String getNumeric(final char[] chars, final int idx) {
		StringBuilder sb = new StringBuilder();
		sb.append(chars[idx]);
//		boolean isPointfound=false;
		for (int i = idx + 1; i < chars.length; i++) {
			char c = chars[i];
			if (CommonUtil.isDigit(c) || c=='.') {
				sb.append(c);
			} else {
				break;
			}
		}
		return sb.toString();
	}
}
