package varaiableSizeSlidingWindow;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DefusetheBomb {

	public static void main(String[] args) {

		int[] code = {2,4,9,3};
		//int[] code = {5,7,1,4};
		int k = -2;
		if(k < 0) {
			int[] arr = new int[code.length];
			int count =0;
			for(int i=code.length-1; i>= 0; i--) {
				System.out.println(code[i]);
				arr[count]=code[i];
				count++;
			}
			int[] res = decrypt(arr, k);
			List<Integer> ls = Arrays.stream(res).boxed().collect(Collectors.toList());
			Collections.reverse(ls);
		    System.out.println(ls);
		}
		else {
			int[] result = decrypt(code, k);
		    System.out.println(Arrays.toString(result));
		}	
	}

	private static int[] decrypt(int[] code, int k) {

		int sum = 0;
		int [] result = new int[code.length];
		
		for(int i=0; i<code.length; i++) {
			sum = sum + code[i];
		}
		
		//int oldsum = sum;
		
		System.out.println("total sum:" + sum);
		
		for(int i =0; i< code.length; i++) {
			if(k == 0) { 
				return result;
			}else {
				sum -= code[i];
				sum += code[(i+k)%code.length];
				result[i]=sum;
			}	
			
			//sum = oldsum;
		}
		
		return result;
	}

}
