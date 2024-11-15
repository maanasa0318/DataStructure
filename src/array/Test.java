package array;

import java.util.Arrays;
import java.util.HashSet;

public class Test {

	public static void main(String[] args) {

		int[] nums = {17,18,5,4,6,1};
		System.out.println(conatinsDuplicate(nums));
		
		System.out.println(validAnagram("racecar", "carrace"));
		
		ConcatenationArray(nums);
		
		//1299. Replace Elements with Greatest Element on Right Side
		replaceElementsBruteForce(nums); 
		
		replaceElemnets(nums);
	}
	
	private static void replaceElemnets(int[] nums) {
		// TODO Auto-generated method stub
		
	}

	private static int[] replaceElementsBruteForce(int[] nums) {
		int[] res = new int[nums.length];
		
		for(int i=0; i<nums.length; i++) {
			System.out.println(nums[i]);
			
			int[] subArr = Arrays.copyOfRange(nums, i+1, nums.length);
			System.out.println(Arrays.toString(subArr));
			if(subArr.length != 0) {
				res[i] = Arrays.stream(subArr).max().getAsInt();
			}else {
				res[i] = -1;
			}
		}
		System.out.println(Arrays.toString(res));
		return res;
		
	}

	private static int[] ConcatenationArray(int[] nums) {
		System.out.println("Before Concat array" + Arrays.toString(nums));
		int len = nums.length + nums.length;
		int[] ans = new int[len];
		System.out.println(len);
		int count = 0;
		int length = nums.length;
		
		for(int i=0; i<nums.length; i++) {
			ans[i] = nums[i];
			ans[nums.length + count] = nums[i];
			count ++;
		}
		System.out.println("Concat array" + Arrays.toString(ans));
		
		return ans;
	}

	private static boolean validAnagram(String s, String s2) {
		if(s.length() != s2.length()) {
			return false;
		}
		int[] countFreq = new int[26];
		for(int i=0; i<s.length(); i++) {
			countFreq[s.charAt(i) - 'a'] ++;
		}
		for(int i=0; i<s2.length(); i++) {
			countFreq[s2.charAt(i)-'a'] --;
		}
		
		for(int i=0; i<countFreq.length; i++) {
			if(countFreq[i] != 0) {
				return false;
			}
		}
		return true;
	}


	private static boolean conatinsDuplicate(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for(int i=0; i<nums.length; i++) {
			if(!set.contains(nums[i])) {
				set.add(nums[i]);

			}
			else {
				return true;
			}
			
		}
		return false;
	}

}
