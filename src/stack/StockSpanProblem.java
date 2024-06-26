package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate span of stock’s price for all n days.
The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than or equal to its price on the given day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, 
     then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}*/
public class StockSpanProblem {

	public static void main(String[] args) {

		int[] arr = {100, 80, 60, 70, 60, 75, 85};
		// consequent smaller of equal to left = Nearest greater to left 
		// o/p =    {1,   1,  1,  2,  1,  4, 6} 
		
    // index     0    1   2   3   4   5   6 
		//i/p = {100, 80, 60, 70, 60, 75, 85};
		// o/p = {-1, 100, 80, 80, 70, 80, 100}
		// basically we have to subtract the index to get result 
		
		List<Integer> res = findNearestGreaterToLeft(arr);
		System.out.println("Nearest greatest to left index " + res);
		List<Integer> list = new ArrayList<Integer>();
		for(int i =0; i <= res.size() -1; i++) {
			System.out.println(res.get(i));
			int diff = i - res.get(i);
			list.add(diff);
		}
		System.out.println("Result is "+ list);
	}

	private static List<Integer> findNearestGreaterToLeft(int[] arr) {
		Stack<Pair> stack = new Stack<Pair>();
		// stores the index
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i =0; i <= arr.length-1 ; i++) {
			if( stack.size() == 0) {
				list.add(-1);
			}
			else if( stack.size() > 0 && stack.peek().value > arr [i] ){
				list.add(stack.peek().index);
			}
			else if ( stack.size() > 0 && stack.peek().value < arr [i]) {
				while( stack.size() > 0 && stack.peek().value < arr [i]) {
					stack.pop();
				}
				if(stack.size() == 0) {
					list.add(-1);
				}
				else {
					list.add(stack.peek().index);
				}
			}
			stack.push(new Pair(arr[i], i));
		}	
		return list;
	} 
		
}

