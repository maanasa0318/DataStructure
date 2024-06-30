package dynamicProgramming;

/*Input: N = 3, W = 4, profit[] = {1, 2, 3}, weight[] = {4, 5, 1}
Output: 3
Explanation: There are two items which have weight less than or equal to 4. If we select the item with weight 4, the possible profit is 1. And if we select the item with weight 1, the possible profit is 3. So the maximum possible profit is 3. Note that we cannot put both the items with weight 4 and 1 together as the capacity of the bag is 4.

Input: N = 3, W = 3, profit[] = {1, 2, 3}, weight[] = {4, 5, 6}*/
public class KnapsackTopDownDP {

	public static void main(String[] args) {
		int N = 3;
		int W = 4;
		int profit[] = { 1, 2, 3 };
		int weight[] = { 4, 5, 1 };

		int res = knapsack(W, weight, profit, N);
		System.out.println("Max profit is " + res);

	}

	private static int knapsack(int w, int wt[], int val[], int n) {
	    {
	        int[][] t = new int [n+1][w+1];
	        
	        //Initialize matrix
	        for(int i=0; i<w+1; i++) t[0][i] = 0;
	        for(int j=0; j<n+1; j++) t[j][0] = 0;
	        
	        //Choice Diagram to code
	        for(int i = 1; i<n+1; i++){
	            for(int j=1; j<w+1; j++){
	                //1. In case of choice
	                if(wt[i-1] <= j){
	                    t[i][j] = Math.max(val[i-1] + t[i-1][j-wt[i-1]], t[i-1][j]);
	                }
	                //2. No choice
	                else if(wt[i-1] > j){
	                    t[i][j] = t[i-1][j];
	                }
	            }
	        }
	        return t[n][w];
	    }
		
	}

}
