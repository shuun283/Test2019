package shuun.chapte7.sort;

/**
 * 平均計算量： O(n2)<br>
 * <br>
 * 1.整列済みのインデックス'A'を決定するく<br>
 * 2.'A'の次の要素'B'を整列されていない部分とする<br>
 * 3.'B'を'A'に挿入する<br>
 * 4.A'と'B'の値を比較して'B'の値が小さければ'A'と交換する<br>
 * 5.'A'と'B'が整列された部分になる<br>
 * 6.'B'の次の要素'C'を整列されていない部分とする<br>
 * 7.整列済みの部分'A','B'に'C'を挿入する<br>
 * 8.隣り合う'C'と'B'の値を比較して'C'の値が小さければ'B'と交換する<br>
 * 9.さらに'C'と'A'の値を比較して'C'の値が小さければ'A'と交換する<br>
 * 
 * @author シンク
 *
 */
public class InsertionSort {

	public static void main(String[] args) {
		int[] test = { 10, 75, 24, 32, 98, 72, 88, 43, 60, 35, 54, 62, 2, 12, 82, };
		InsertionSort.sort(test);
		for (int i = 0; i < test.length; i++) {
			System.out.println((i + 1) + ":" + test[i]);
		}

	}

	public static void sort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int j = i;
			while (j >= 1 && array[j - 1] > array[j]) {
				int tmp = array[j];
				array[j] = array[j - 1];
				array[j - 1] = tmp;
				j--;
			}
		}
	}
}
