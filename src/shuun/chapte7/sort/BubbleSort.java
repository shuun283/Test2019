package shuun.chapte7.sort;

/**
 * 平均計算量： O(n2)<br>
 * <br>
 * 1.先頭の要素'A'と隣り合う次の要素'B'の値を比較する<br>
 * 2.要素'A'が要素'B'より大きいなら、要素'A'と要素'B'の値を交換する<br>
 * 3.先頭の要素を'B'に移し、要素'B'と隣り合う要素'C'の値を比較/交換する<br>
 * 4.先頭の要素を'C','D','E'...と移動しながら比較/交換をリストの終端まで繰り返す<br>
 * 5.最も大きい値を持つ要素がリストの終端へ浮かびあがる<br>
 * 6.リストの終端には最も大きな値が入っているので、リストの終端の位置をずらして(要素数をひとつ減らして)手順1〜6を繰り返す<br>
 * 
 * @author シンク
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] test = { 10, 75, 24, 32, 98, 72, 88, 43, 60, 35, 54, 62, 2, 12, 82, };
		BubbleSort.sort(test);
		for (int i = 0; i < test.length; i++) {
			System.out.println((i + 1) + ":" + test[i]);
		}

	}

	public static void sort(int[] array) {
		int temp;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}

	}
}
