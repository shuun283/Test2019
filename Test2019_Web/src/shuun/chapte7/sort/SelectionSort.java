package shuun.chapte7.sort;

/**
 * 平均計算量： O(n2)<br>
 * <br>
 * 1.配列の先頭要素を仮の最小値を持つ要素"A0"としておく<br>
 * 2."A0"と"A0"以外の要素の値を比較して"A0"より小さい値を持つ要素"A1"が見付かれば"A0"と"A0"の値を交換する<br>
 * 3.2.を繰り返すことで"A0"には配列内での最小値がセットされる<br>
 * 4.次は"A0"を除いて"A1"と"A1"以外の要素、"A1"を除いて"A2"と"A2"以外の要素を比較/交換して整列が完了する<br>
 * 
 * @author シンク
 *
 */
public class SelectionSort {

	public static void main(String[] args) {
		int[] test = { 10, 75, 24, 32, 98, 72, 88, 43, 60, 35, 54, 62, 2, 12, 82, };
		SelectionSort.sort(test);
		for (int i = 0; i < test.length; i++) {
			System.out.println((i + 1) + ":" + test[i]);
		}

	}

	public static void sort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int index = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[index]) {
					index = j;
				}
			}
			if (i != index) {
				int tmp = array[index];
				array[index] = array[i];
				array[i] = tmp;

			}
		}
	}
}
