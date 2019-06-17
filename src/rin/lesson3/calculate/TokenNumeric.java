package rin.lesson3.calculate;

public class TokenNumeric extends Token{
	
	public TokenNumeric(String strNumeric) {
		super.value = strNumeric;
	}

	public double getDoubleValue(){
		return Double.parseDouble(super.toString());
	}

	@Override
	public boolean isOperator() {
		return false;
	}

	@Override
	public boolean isNumeric() {
		return true;
	}

	public int isPriorityHigherThan(Token token) {
		return 9;
	}

}
