package shou.calculator;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws FormatException {

		List<String> expresses = new ArrayList<String>();
		expresses.add("1+2+3");
		expresses.add("(1+3)*5");
		expresses.add("(2+3+4)");
		expresses.add("(2+3)/(-)/(11+6)");

		expresses.forEach(express -> {
			Formattor formattor = new Formattor();
			Calculator calculator = new Calculator();
			double d = calculator.calculate(formattor.postfix(formattor.formatIntoTokens(express)));
			System.out.println(express + "=" + d);

		});

	}

}
