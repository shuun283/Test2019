package rin.lesson5IO.calculate;

public enum TokenType {//

	/* 加算符号 */
	ADD(0, '+'),
	/* 減算符号 */
	MINUS(1, '-'),
	/* 乗算符号 */
	MULTIPLY(2, '*'),
	/* 割り算符号 */
	DIVIDE(3, '/'),
	/* 左括弧符号 */
	PAREN_OPEN(4, '('),
	/* 右括弧符号 */
	PAREN_CLOSE(5, ')'),
	/* 数値 */
	NUMERIC(6, '#'),//
	;
	private int index;
	private char value;

	TokenType(int index, char value) {
		this.index = index;
		this.value = value;
	}

	public int getIndex() {
		return this.index;
	}

	public char getValue() {
		return this.value;
	}

}
