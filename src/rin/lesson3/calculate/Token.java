package rin.lesson3.calculate;

public abstract class Token {
	
	private Object value;
	public Token(String value){
		this.value = value;
	}
	public String toString(){
		return this.getValue().toString();
	}
	public abstract boolean isOperator();
	public abstract boolean isNumeric();
	public abstract int isPriorityHigherThan(Token token);
	public Object getValue() {
		return value;
	}
//	public static void setValue(Object value) {
//		Token.value = value;
//	}
}
