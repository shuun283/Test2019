package shou.calculator;

public interface Token {
	
	int getPriority();
	
	double calculate(double a, double b);
}