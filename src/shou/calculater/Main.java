package shou.calculater;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws FormatException {
        System.out.print("式を入力してください：");
        Scanner scanner = new Scanner(System.in);
        String express = scanner.nextLine();
        Calculater calculater = new Calculater(express);
        System.out.println(calculater.calculate());
    }
}
