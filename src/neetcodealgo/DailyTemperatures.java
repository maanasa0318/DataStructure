package neetcodealgo;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

	public static void main(String[] args) {

		int[] temp = {73,74,75,71,69,72,76,73};
		int[] res = dailyTemp(temp);
		System.out.println(Arrays.toString(res));
	}

	private static int[] dailyTemp(int[] temp) {
		Stack<Integer> st = new Stack<>();
		int n = temp.length;
		int[] res = new int[n];
		
		for(int i= n-1; i>=0; i--) {
			while(!st.empty() && temp[st.peek()] <= temp[i]) {
				// remove from stack;
				st.pop();
			}
			
			if(!st.empty()) {
				res[i] = st.peek() - i;
			}
			else {
				res[i] =0;
			}
			st.push(i);
		}
		return res;
	}

}
