package neetcodealgo;

import java.util.HashMap;
import java.util.PriorityQueue;

public class HandofStraights {

	public static void main(String[] args) {
		int[] hand = { 1, 2, 4, 2, 3, 5, 3, 4 };
		int groupSize = 4;
		System.out.println(isNStraightHand(hand, groupSize));
	}

	public static boolean isNStraightHand(int[] hand, int groupSize) {
		if (hand.length % groupSize != 0) {
			return false;
		}

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < hand.length; i++) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		PriorityQueue<Integer> minHeap = new PriorityQueue<>(map.keySet());
		while (!minHeap.isEmpty()) {
			int first = minHeap.peek();
			for (int i = 0; i < first + groupSize; i++) {
				if (!map.containsKey(i)) {
					return false;
				}
				// decrement the map count of i
				map.put(i, map.get(i) - 1);
				if (map.get(i) == 0) {
					if (minHeap.peek() != i) {
						return false;
					}
					minHeap.poll();
				}
			}
		}
		return true;

	}

}
