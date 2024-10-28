package slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SlidingSubarrayBeauty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {-46,-34};
		int k = 1; 
		int position = 1;
		int[] result = getSubarrayBeauty(nums, k, position);
		Arrays.stream(result).forEach(System.out::println);
				
	}

	private static int[] getSubarrayBeauty(int[] nums, int k, int position) {
		int i =0;
		int j =0;
		List<Integer> result = new ArrayList<Integer>();
		List<Integer> temp = new ArrayList<Integer>();

		
		while(j < nums.length) {
			//condition
			temp.add(nums[j]);
			
			if(j - i + 1 < k) {
				j++;
			}
			else if ( j - i + 1 == k) {
				//calculation
				int elemt = getelement(temp, position);
				if(elemt < 0) {
					result.add(elemt);
				}else {
					result.add(0);
				}
				
				if(temp.size() > 1) {
				//remove element at index i
				if(temp.get(i)== nums[i]) {
					//check size of list
					if(temp.size() > 1) {
						temp.remove(i);
					}
				}
				}else {
					temp.clear();
				}
				
				//slide window
				i++;
				j++;
				
			}
		}
		int[] answer = result.stream().mapToInt(Integer::intValue).toArray();

		return answer;
	}

	private static int getelement(List<Integer> temp, int position) {
		int[] answer = temp.stream().mapToInt(Integer::intValue).toArray();
		Arrays.sort(answer);

		return answer[position-1];
	}

}
