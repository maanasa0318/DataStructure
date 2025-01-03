package neetcodealgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {

		int[][] nums = {{1, 2, 3}, {4 ,5 ,6}, {7, 8, 9}};
		List<Integer> res = spiralMatrix(nums);
		System.out.println(res);
	}

	private static List<Integer> spiralMatrix(int[][] nums) {
		List<Integer> res = new ArrayList<>();
		int left = 0;
		int right = nums[0].length-1;
		int top =0;
		int bottom = nums.length-1;
		
		while(left <= right && top <= bottom) {
			for(int i=left; i<=right; i++) {
				res.add(nums[top][i]);
			}
			top ++;
			
			for(int i=top; i<= bottom ; i++) {
				res.add(nums[i][right]);
			}
			right--;
			if(top <= bottom) {
				for(int i =right; i>=left; i--) {
					res.add(nums[bottom][i]);
				}
				bottom--;
			}
			if(left <= right) {
				for(int i=bottom; i<=top; i++) {
					res.add(nums[i][left]);
				}
				left++;
			}
		}
	
		return res;
	}

}
