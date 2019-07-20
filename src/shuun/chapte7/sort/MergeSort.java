package shuun.chapte7.sort;

/**
 * 平均計算量：O(nlogn)<br>
 * <br>
 * 1.整列されていないリストを2つのサブリストに分割するく<br>
 * 2.サブリストを整列する<br>
 * 3.サブリストをマージしてひとつの整列済みリストにする<br>
 * 
 * @author シンク
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		int[] test = { 10, 75, 24, 32, 98, 72, 88, 43, 60, 35, 54, 62, 2, 12, 82, };
		MergeSort.sort(test, 0, test.length - 1);
		for (int i = 0; i < test.length; i++) {
			System.out.println((i + 1) + ":" + test[i]);
		}
	}

	public static void sort(int[] array, int low, int high) {
		if (low < high) {
			int middle = (low + high) >>> 1;
			MergeSort.sort(array, low, middle);
			MergeSort.sort(array, middle + 1, high);
			MergeSort.merge(array, low, middle, high);
		}
	}

	public static void merge(int[] array, int low, int middle, int high) {
		int[] helper = new int[array.length];

		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}
		int helperLeft = low;
		int helperRight = middle + 1;
		int current = low;

		while (helperLeft <= middle && helperRight <= high) {
			if (helper[helperLeft] <= helper[helperRight]) {
				array[current] = helper[helperLeft];
				helperLeft++;
			} else {
				array[current] = helper[helperRight];
				helperRight++;
			}
			current++;
		}
		int remaining = middle - helperLeft;
		for (int i = 0; i <= remaining; i++) {
			array[current + i] = helper[helperLeft + i];
		}
	}

}
