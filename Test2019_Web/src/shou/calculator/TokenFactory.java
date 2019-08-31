package shou.calculator;

import java.math.BigDecimal;

public class TokenFactory {
	
	/*符号の場合、パラメータはcharである*/
	public Token getToken (char c) {
		switch (c) {
		case '+':
			return new Add();
		case '-':
			return new Minus();
		case '*':
			return new Multiply();
		case '/':
			return new Devide();
		case '(':
			return new LeftBrackets();
		case ')':
			return new RightBrackets();				
		}
		return null;	
	}
	
	/*数字の場合、パラメータはStringである*/
	public Token getToken (StringBuilder tokenString){
		return new Digital(Double.parseDouble(tokenString.toString()));
	}
	public Token getToken (Double d){	
		return new Digital(d);
	}
	
}


/*加算*/
class Add implements Token{

	@Override
	public int getPriority() {
		return 0;
	}		

	@Override
	public double calculate(double a, double b) {
		return a + b;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "+";
	}


}

/*減算*/
class Minus implements Token{

	@Override
	public int getPriority() {
		return 0;
	}	
	
	public double calculate(double a, double b) {
        return a - b;
    }
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "-";
	}
}

/*乗算*/
class Multiply implements Token{

	@Override
	public int getPriority() {
		return 1;
	}
	
	public double calculate(double a, double b) {
        return a*b;
    }
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "*";
	}
}

/*割り算*/
class Devide implements Token{

	@Override
	public int getPriority() {
		return 1;
	}	
	
	@SuppressWarnings({ "unused", "deprecation" })
	public double calculate (double a, double b){
        BigDecimal b1 = new BigDecimal(a);
        BigDecimal b2 = new BigDecimal(b); 

        return b1.divide(b2, 3, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "/";
	}
}

/*左括弧*/
class LeftBrackets implements Token{

	@Override
	public int getPriority() {
		return -1;
	}

	@Override
	public double calculate(double a, double b) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(";
	}
	
}

/*右括弧*/
class RightBrackets implements Token{

	@Override
	public int getPriority() {
		return -2;
	}

	@Override
	public double calculate(double a, double b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ")";
	}
}

/*数字*/
class Digital implements Token{
	
	/*数字の値*/
	private double value;
	public double getValue() {
		return value;
	}
	
	/*コンストラクタ*/
	public Digital(double d) {
		this.value = d;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return value+"";
	}
	
	@Override
	public int getPriority() {
		return -3;
	}

	@Override
	public double calculate(double a, double b) {
		// TODO Auto-generated method stub
		return 0;
	}

}