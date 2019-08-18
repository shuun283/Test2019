package shou.calculator;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws FormatException {
        Scanner scanner = new Scanner(System.in);
    	while (!scanner.nextLine().equals("0")) {
        	System.out.print("式を入力してください：");           
            String express = scanner.nextLine();
            Calculator calculator = new Calculator();
            double d = calculator.calculate(calculator.formatIntoTokens(express));
            System.out.println("結果は"+d+"です。");
            System.out.println("0を押すと終了となります。");
		}
    	scanner.close();
    	
    	
    }
}
