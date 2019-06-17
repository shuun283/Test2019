package rin.lesson3.calculate;

public abstract class Token {
	
	protected static Object value;
	public Token(){
	}
	public Token(String value){
		this.value = value;
	}
//	public String toString(){
//		return this.value.toString();
//	}
	public abstract boolean isOperator();
	public abstract boolean isNumeric();
	public abstract int isPriorityHigherThan(Token token);
}
