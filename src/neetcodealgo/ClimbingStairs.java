package neetcodealgo;

public class ClimbingStairs {

	public static void main(String[] args) {

		int i =5;
		int res = ClimbingStairs(i);
		System.out.println(res);
		
		int steps = climbStairs(i);
		System.out.println(steps);
	}

	//time o(n) space - o(1)
	private static int ClimbingStairs(int n) {
		int one =1;
		int two = 1;
		
		for(int i=0; i<n-1; i++) {
			int temp = one;
			one = one + two;
			two = temp;
		}
		
		return one;
	}
	
	// recursive solution time o(2n) space o(n)
	public static int climbStairs(int n) {
        return dfs(n, 0); 
    }

    public static int dfs(int n, int i) {
       //base case
       if(i >= n) {
    	   return i == n? 1:0;
       }
       return dfs(n, i+1)+dfs(n, i+2);
    }
}
