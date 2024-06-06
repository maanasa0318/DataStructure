package dynamicProgramming;

public class KnapsackRecursive01 {

	public static void main(String[] args) {

		int N = 4;
		int W = 7;
		int value[] = {1, 3, 4, 5};
		int weight[] = {1, 4, 5, 7};
		int res = knapsack(weight, value, W, N);
		
	}

	private static int knapsack(int[] weight, int[] value, int w, int n) {
		if(n ==0 || w ==0) {
			return 0;
		}
		if(weight[n-1]<= w) {
			//return Math.max(value[n-1] +, n)
		}
		return 0;
	}

}
