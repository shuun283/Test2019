package shuun.chapte7.sort;

/**
 * 平均計算量：O(nk)<br>
 * <br>
 * 前提としてソート対象のデータは 0 から 5 の整数とします。ソート対象の配列Aを {5,3,3,1,4} としておく<br>
 * <br>
 * 1.キー(配列Aのデータ)を数え上げるための配列Cとソートのための2. 作業用配列Bを用意する<br>
 * 2.配列Aのデータの出現頻度を数える(配列Cを利用)<br>
 * 3.キーの累積度数分布を求める(配列Cが保持)<br>
 * 4.(配列Cの)累積度数分布に従って配列Aから配列Bにデータをコピーする(必要なら配列Bから元の配列Aにデータをコピーする)<br>
 * 
 * @author シンク
 *
 */
public class CountingSort {

	public static void main(String[] args) {
		int[] test = { 10, 75, 24, 32, 98, 72, 88, 43, 60, 35, 54, 62, 2, 12, 82, 2, 12, 12 };
		test = CountingSort.sort(test, 100);
		for (int i = 0; i < test.length; i++) {
			System.out.println((i + 1) + ":" + test[i]);
		}
	}

	public static int[] sort(int[] array, int maxValue) {
		int[] counts = new int[maxValue + 1];

		for (int i = 0; i < array.length; i++) {
			counts[array[i]]++;
		}

		int total = 0;
		for (int i = 0; i <= maxValue; i++) {
			int count = counts[i];
			counts[i] = total;
			total += count;
		}

		int[] sortedValues = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			sortedValues[counts[array[i]]] = array[i];
			counts[array[i]]++;
		}
		return sortedValues;
	}
}
