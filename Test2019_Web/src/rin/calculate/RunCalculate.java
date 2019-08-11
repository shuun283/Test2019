package rin.calculate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class RunCalculate {

	/**
	 * 四則演算する
	 * @param args
	 */
	public static void main(String[] args) {

		File fileIn = new File("H:\\eclipse\\workspace\\Test2019\\src\\rin\\rin_test.txt");
		File fileOut = new File("H:\\eclipse\\workspace\\Test2019\\src\\rin\\rin_test_out.txt");
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			if (!fileIn.exists()) {
				System.out.println("file not found!");
			}
			if (!fileOut.exists()) {
				fileOut.createNewFile();
			}
			br = new BufferedReader(new FileReader(fileIn));
			bw = new BufferedWriter(new FileWriter(fileOut));
			int i = 1;
			String exp = br.readLine();
			while (exp != null) {
				String result = doExcute(exp);
				System.out.println((i++) + "行目：" + exp + " = " + result);
				bw.write(exp + " = " + result);
				exp = br.readLine();
				bw.newLine();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 四則演算メソッド
	 * 
	 * @param exp
	 */
	private static String doExcute(final String exp){
		String result = null;
		try {
			char[] chars = exp.toCharArray();
			List<Token> infixTokenList = AnalyzeUtil.analyzeExpression(chars);
			List<Token> postfixTokenList = ConvertUtil.toPostfixList(infixTokenList);
			result = Double.toString(CalculateUtil.calcutePostfixExp(postfixTokenList));
		} catch (CalcuteException e) {
			result = e.getMessage();
		}
		return result;
	}

}
