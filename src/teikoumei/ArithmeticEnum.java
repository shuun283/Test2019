package teikoumei;

public enum ArithmeticEnum {
	PLUS("+"),
	MINUS("-"),
	TIMES("*"),
	DIVIDE("/");
	
	private String arithmetic;

	private ArithmeticEnum(String ari) {
		this.arithmetic = ari;
	}
}
