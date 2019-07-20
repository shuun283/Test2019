package shuun.chapte7.sort;

/**
 * 平均計算量：O(n+k)<br>
 * <br>
 * 前提としてソート対象のデータは 1 から 10 の整数とします。<br>
 * <br>
 * 1.1 から 10 に対応する10個のバケットを順に並べて用意する<br>
 * 2.データを対応するバケットに入れる<br>
 * 3.バケットから順にデータを取り出す<br>
 * 
 * @author シンク
 *
 */
public class BucketSort {

	public static void main(String[] args) {
		int[] test = { 10, 75, 24, 32, 98, 72, 88, 43, 60, 35, 54, 62, 2, 12, 82, };
		BucketSort.sort(test, 100);
		for (int i = 0; i < test.length; i++) {
			System.out.println((i + 1) + ":" + test[i]);
		}
	}

	public static void sort(int[] array, int maxValue) {
		int[] bucket = new int[maxValue + 1];

		for (int i = 0; i < bucket.length; i++) {
			bucket[i] = 0;
		}

		for (int i = 0; i < array.length; i++) {
			bucket[array[i]]++;
		}

		int outPos = 0;
		for (int i = 0; i < bucket.length; i++) {
			for (int j = 0; j < bucket[i]; j++) {
				array[outPos++] = i;
			}
		}
	}
}
