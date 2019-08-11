package teikoumei;

import java.util.ArrayList;
import java.util.List;

public class TestArithmetic {

	public static void main(String[] args) throws Exception {
		ArithmeticIF arithmetic = new Arithmetic();
		List<String> list = testData();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("四則演算式" + (i + 1));
			arithmetic.Operation(list.get(i));
			System.out.println("==========================================");
		}
	}

	public static List<String> testData() {
		//a + b * c + (d * e + f)*g
		List<String> list = new ArrayList<String>();
		list.add("2+3*1+(4*5+6)*7");
		//list.add("-1+22*5/2*(2+5)");
		//list.add("123+1+88*4/2");
		//list.add("1/0");
		//list.add("%2-2*2+2");
		return list;
	}
}
