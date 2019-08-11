package shuun.chapte7.sort;

/**
 * 平均計算量：O(nlogn)<br>
 * <br>
 * 1.整列対象の配列内にボトムアップでヒープを構築する<br>
 * 2.構築されたヒープの先頭要素[1]と最後の要素[N]を交換する<br>
 * 3.要素[1]から要素[N-1]でヒープを再構成する<br>
 * 4.ヒープの先頭要素[1]と最後の要素[N-1]を交換する<br>
 * 5.3.に戻る(4.にある最後の要素は[N-2],[N-3]...と移動する)<br>
 * 6.ヒープ構造がなくなれば整列完了<br>
 * 
 * @author シンク
 *
 */
public class HeapSort {

	public static void main(String[] args) {
		int[] test = { 10, 75, 24, 32, 98, 72, 88, 43, 60, 35, 54, 62, 2, 12, 82, };
		HeapSort.sort(test);
		for (int i = 0; i < test.length; i++) {
			System.out.println((i + 1) + ":" + test[i]);
		}
	}

	public static void sort(int[] array) {
		int n = array.length;

		for (int i = n / 2 - 1; i >= 0; i--) {
			heap(array, n, i);
		}

		for (int i = n - 1; i >= 0; i--) {
			if (array[0] > array[i]) {
				int tmp = array[0];
				array[0] = array[i];
				array[i] = tmp;
				heap(array, i - 1, 0);
			}

		}
	}

	public static void heap(int[] array, int n, int root) {
		int largest = root;
		int left = 2 * root + 1;
		int right = 2 * root + 2;

		if (left < n && array[left] > array[largest]) {
			largest = left;
		}

		if (right < n && array[right] > array[largest]) {
			largest = right;
		}

		if (largest != root) {
			int swap = array[root];
			array[root] = array[largest];
			array[largest] = swap;

			heap(array, n, largest);
		}
	}
}