package rin.lesson5IO.calculate;

public class TokenNumeric extends Token {

	public TokenNumeric(String strNumeric) {
		super(strNumeric, TokenType.NUMERIC);
	}

	public double getDoubleValue() {
		return Double.parseDouble(this.getStringValue());
	}

}
