package queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextLargestElement {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4};
        List<Integer> res = getGreaterToRight(arr);
        for(int i : res) {
        	System.out.println(i);
        }
    }

    static List<Integer> getGreaterToRight(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int size = arr.length;
        List<Integer> result = new ArrayList<Integer>();
        
        for(int i = size-1;i>=0;i--){
	    	 if (stack.isEmpty()) {
	    		 result.add(-1);
	         }
	    	 else if (!stack.isEmpty() && stack.peek() > arr[i]) {
	    		 result.add( stack.peek());

	    	 }
	    	 else if (!stack.isEmpty() && stack.peek() < arr[i]) {
	            while (!stack.isEmpty() && stack.peek() < arr[i]) {
	                stack.pop();
	            }
	            if (stack.isEmpty()) {
		    		 result.add(-1);

	            } else {
		    		 result.add( stack.peek());
	            }
	    	 }
            stack.push(arr[i]);
        }
        return result.reversed();
    }
}