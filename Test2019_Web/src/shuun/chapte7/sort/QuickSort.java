package shuun.chapte7.sort;

/**
 * 平均計算量：O(nlogn)<br>
 * <br>
 * 1.要素数が1つかそれ以下なら整列済みとみなしてソート処理を行わない<br>
 * 2.ピボットとなる要素をピックアップする<br>
 * 3.ピボットを中心とした2つの部分に分割する - ピボットの値より大きい値を持つ要素と小さい値を持つ要素<br>
 * 4.分割された部分(サブリスト)に再帰的にこのアルゴリズムを適用する<br>
 * 
 * @author シンク
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] test = { 10, 75, 24, 32, 98, 72, 88, 43, 60, 35, 54, 62, 2, 12, 82, };
		QuickSort.sort(test, 0, test.length - 1);
		for (int i = 0; i < test.length; i++) {
			System.out.println((i + 1) + ":" + test[i]);
		}
	}

	public static void sort(int[] array, int left, int right) {
		if (left <= right) {
			int p = array[(left + right) >>> 1];
			int l = left;
			int r = right;
			while (l <= r) {
				while (array[l] < p) {
					l++;
				}
				while (array[r] > p) {
					r--;
				}
				if (l <= r) {
					int tmp = array[l];
					array[l] = array[r];
					array[r] = tmp;
					l++;
					r--;
				}
			}
			QuickSort.sort(array, left, r);
			QuickSort.sort(array, l, right);
		}
	}
}
