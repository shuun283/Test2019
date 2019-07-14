package rin.lesson4.calculateOfComplex;

public class TokenNumeric extends Token {

	public TokenNumeric(String strNumeric) {
		super(strNumeric, TokenType.NUMERIC);
	}

	public double getDoubleValue() {
		return Double.parseDouble(this.toString());
	}

}
