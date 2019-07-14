package rin.lesson4.calculate;

public class TokenNumeric extends Token {

	public TokenNumeric(String strNumeric) {
		super(strNumeric, TokenType.NUMERIC);
	}

	public double getDoubleValue() {
		return Double.parseDouble(this.toString());
	}

}
