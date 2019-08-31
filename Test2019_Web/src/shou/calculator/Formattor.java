package shou.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Formattor {

	/**
	 * 文字列の式をTokenのListに変換する
	 * 
	 * @param String
	 * @return List<Token>
	 */
	public List<Token> formatIntoTokens(String expression) {
		// todo:space
		List<Token> tokens = new ArrayList<Token>();
		char[] chars = expression.toCharArray();

		StringBuilder sb = new StringBuilder("");
		TokenFactory tf = new TokenFactory();

		// 先頭の確認
		char c = chars[0];
		if ('0' <= c && c <= '9') {
			sb.append(c);
		} else {
			tokens.add(tf.getToken(c));
		}

		for (int i = 1; i < chars.length; i++) {
			c = chars[i];
			if ('0' <= c && c <= '9' || c == '.') {
				// 数字の場合
				sb.append(c);
			} else if (c == '-') {
				if (chars[i - 1] == '(') {
					// 負数だと認識できる
					sb.append(c + "");
				} else {
					// 減算符号だと認識できる
					// 他の符号の場合、まず数字の採番終了
					tokens.add(tf.getToken(sb));
					sb = new StringBuilder("");
					// そしてその符号をtokensに入れる
					tokens.add(tf.getToken(c));
				}
			} else {
				// 他の符号の場合、まず数字の採番終了
				if (sb.length() > 0) {
					tokens.add(tf.getToken(sb));
				}

				sb = new StringBuilder("");
				// そしてその符号をtokensに入れる
				tokens.add(tf.getToken(c));
			}
		}
		if (sb.length() > 0) {
			tokens.add(tf.getToken(sb));
		}
		return tokens;

	}

	/**
	 * TokenのListを後置記法に変換する
	 * 
	 * @param List<Token>
	 * @return List<Token>
	 */
	public List<Token> postfix(List<Token> tokens) {
		Stack<Token> s1 = new Stack<>();
		Stack<Token> s2 = new Stack<>();
		for (Token t : tokens) {
			switch (t.getPriority()) {
			case -3:// 数字
				s1.push(t);
				break;
			case -2:// 右括弧
				do {
					s1.push(s2.pop());
				} while (s2.peek().getPriority() != -1);
				s2.pop();
				break;
			default:
				if (s2.empty() || t.getPriority() > s2.peek().getPriority()||t.getPriority()==-1) {
					s2.push(t);
				} else {
					do {
						s1.push(s2.pop());
					} while (s1.peek().getPriority() == 1);
					s2.push(t);
				}
			}
		}
		while (!s1.empty()) {
			s2.push(s1.pop());
		}
		List<Token> tokenList = new ArrayList<>();
		while (!s2.empty()) {
			tokenList.add(s2.pop());
		}
		return tokenList;
	}
}
