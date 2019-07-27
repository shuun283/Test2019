package rin.lesson7Algorithm;

public class SortAction {

	public static void main(String[] args) {
		int[] targetArr = { 52, 126, 3, 98, 425, 1, 33, 78, 15, 8 };
//		System.out.println(bblSort(targetArr).toString());
//		System.out.println(selectSort(targetArr).toString());
		System.out.println(insertSort(targetArr).toString());

	}

	public static int[] bblSort(final int[] targetArr) {
		int[] resultArr = targetArr;
		int tmpInt = 0;
		for (int i = resultArr.length - 1; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				if (resultArr[j] < resultArr[j - 1]) {
					tmpInt = resultArr[j];
					resultArr[j] = resultArr[j - 1];
					resultArr[j - 1] = tmpInt;
				}
			}
		}
		return resultArr;
	}

	public static int[] selectSort(final int[] targetArr) {
		int[] resultArr = targetArr;
		for (int i = 1; i < resultArr.length; i++) {
			int left = resultArr[i-1];
			int tmpMax = resultArr[i];
			int maxIndex = i;
			for (int j = i+1; j < resultArr.length; j++) {
				if (resultArr[j] > tmpMax) {
					tmpMax = resultArr[j];
					maxIndex = j;
				}
			}
			if(left < tmpMax) {
				resultArr[maxIndex] = left;
				resultArr[i-1] = tmpMax;
			}

		}
		return resultArr;
	}

	public static int[] insertSort(final int[] targetArr) {
		int[] resultArr = targetArr;
		int tmp = 0;
		for (int i = 1; i < resultArr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (resultArr[j] < resultArr[j-1]) {
					tmp = resultArr[j];
					resultArr[j] = resultArr[j-1];
					resultArr[j-1] = tmp;
				}
			}
		}
		return resultArr;
	}

}
