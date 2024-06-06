package slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class FirstNegativeNumber {

	public static void main(String[] args) {
		int[] array = { 12, -1, -7, 8, 15, 30, 16, 28 };
		int windows = 3;
		findFirstnegativeNumberInWindow(array, windows);
	}

	private static void findFirstnegativeNumberInWindow(int[] array, int window) {
		List<Integer> answer = new ArrayList<Integer>();
		int i = 0;
		int j = 0;
		int size = array.length;

		while (j < size) {
			if (array[j] < 0) {
				answer.add(array[j]);
			}
			if (j - i + 1 < window) {
				j++;
			} else {
				if (answer.size() == 0) {
					System.out.println(0);
				} else {
					System.out.println(answer.get(0));
					if (array[i] == answer.get(0)) {
						answer.remove(0);
					}
					// slide the window
					i++;
					j++;
				}
			}
		}
	}

}
