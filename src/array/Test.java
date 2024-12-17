package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Test {

	public static void main(String[] args) {

		int[] nums = {1,2,3,2,2};
		int slow =nums[0];
		int fast =nums[0];
		while(true) {
			slow = nums[slow];
			fast = nums[nums[fast]];
			System.out.println(slow);
			System.out.println(fast);
			if(slow == fast) {
				break;
			}
			System.out.println();
		}
	  
		//System.out.println(conatinsDuplicate(nums));
		
		System.out.println(validAnagram("racecar", "carrace"));
		
		ConcatenationArray(nums);
		
		//1299. Replace Elements with Greatest Element on Right Side
		replaceElementsBruteForce(nums); 
		
		replaceElemnets(nums);
		
		String s = "abc", t = "ahbgdc";
		System.out.println(isSubsequence(s, t));
		
		 //Length of Last Word
		lenOfLastWord("Hello World");
		
		//Monotonic Array
		int[] arr = {1,1,0};
		System.out.println("array is monotonic " +isMonotonic(arr));
		
		char[] rev = {'T','e','s','t'};
		rev = rev(rev);
		
		int[] numbers = {2,7,11,15};
		int target = 9;
		int[] result = twoSum(numbers, target);
		System.out.println(Arrays.toString(result));
	}
	
	

	private static int[]  twoSum(int[] nums, int target) {

		HashMap<Integer, Integer> hmap = new HashMap<>();
		for(int i=0; i<nums.length; i++) {
			hmap.put(nums[i], i);
		}
		for(int i=0; i<nums.length; i++) {
			int diff = target - nums[i];
			if(hmap.containsKey(diff)) {
				return new int[] {i, hmap.get(diff)};
			}
		}
		return new int[] {};
	}



	private static char[] rev(char[] s) {
		int l=0;
		int r=s.length -1;
		while(l <= r) {
			
			char temp = s[l];
			s[l] = s[r];
			s[r] = temp;
			l++;
			r--;
			
		}
		System.out.println(Arrays.toString(s));
		return s;
	}



	private static boolean isMonotonic(int[] arr) {
		boolean increasingSeq = false;
		boolean decreasingSeq = false;
		int i=0;
		if(arr[i] > arr[arr.length-1]) {
			decreasingSeq = true;
			return (checkMontonicForDecresingSequ(arr));

		}else {
			increasingSeq = true;
			return(checkMontonicForIncreasingSequ(arr));
		}
		
	}

	private static boolean checkMontonicForIncreasingSequ(int[] arr) {
		int i =0;
		int j =1; 
		while(j < arr.length) {
			
			if(i <= j && arr[i] <= arr[j] ) {
				i++;
				j++;
			}
			else {
				return false;
			}
		}
		
		return true;
	}

	private static boolean checkMontonicForDecresingSequ(int[] arr) {
		int i =0;
		int j =1; 
			while(j < arr.length) {
			
			if (i <= j && arr[i] >= arr[j]) {
				i++;
				j++;
			}
			else {
				return false;
			}
		}
		
		return true;
	}

	private static void lenOfLastWord(String string) {

		String[] str = string.trim().split(" ");
		String s = str[str.length-1];
		System.out.println(s.length());
	}

	private static boolean isSubsequence(String s, String t) {
		int i=0;
		int j=0;
		while(i < s.length() && j < t.length()) {
			if(s.charAt(i) == t.charAt(j)) {
				i++;
			}
			j++;
			
		}
		if (i == s.length()) {
			return true;
		}else {
			return false;
		}
	}

	private static void replaceElemnets(int[] nums) {
		int rightMax = -1;
		// max = (oldmax,nums[i])
		int newMax = 0;
		
		for(int i=nums.length - 1; i>=0; i--) {
			newMax = Math.max(rightMax, nums[i]);
			nums[i] = rightMax;
			rightMax = newMax;
		}
		System.out.println(Arrays.toString(nums));

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
