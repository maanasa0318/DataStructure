package tuf;

import java.util.ArrayList;
import java.util.Arrays;

public class LeftRotateArraKPlaces {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 2;

        System.out.println("Initial array: ");
        printArray(nums, k);
	}

	private static void printArray(int[] nums, int k) {
		int n = nums.length;
        ArrayList<Integer> ele = new ArrayList<>();
		for(int i=0; i<k; i++){
			ele.add(nums[i]);
		}

		for(int i=0; i<n-k; i++){
			nums[i] = nums[i+k];
		}

		int index =0;
		for(int i=n-k; i<n; i++){
			nums[i] = ele.get(index);
			index++;
		}

		System.out.println(Arrays.toString(nums));
		
	}

}
