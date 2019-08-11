package shuun.chapte7.sort;

/**
 * 平均計算量： O(log2n)<br>
 * <br>
 * 1.配列をソートする(ここでは昇順でソートされたとする)<br>
 * 2.配列の中央にある要素を調べる<br>
 * 3.中央の要素が目的の値ではなく、目的のデータが中央の値より大きい場合、中央より後半の部分を調べる<br>
 *   中央の要素が目的の値ではなく、目的のデータが中央の値より小さい場合、中央より前半の部分を調べる<br>
 * 4.2.に戻る<br>
 * 
 * @author シンク
 *
 */
public class BinarySearch {

	public static void main(String[] args) {
		int[] data = { 23, 25, 53, 444, 5466, 12646 };
		boolean result;
		result = BinarySearch.execute(data, 25);
		if (result) {
			System.out.println("Found!");
		} else {
			System.out.println("Not Found.");
		}
	}

	public static boolean execute(int[] data, int target) {
		int low = 0;
		int high = data.length - 1;
		while (low <= high) {
			int middle = (low + high) >>> 1;
			if (data[middle] == target) {
				return true;
			} else if (data[middle] < target) {
				low = middle + 1;
			} else {
				high = middle - 1;
			}
		}
		return false;
	}

}
