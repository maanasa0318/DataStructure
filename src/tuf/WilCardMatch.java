package tuf;

import java.util.Arrays;

public class WilCardMatch {

	public static void main(String[] args) {

		String S1 = "aa";
        String S2 = "*";
        
        // Create an instance of Solution class
        WilCardMatch sol = new WilCardMatch();

        // Call wildCard function and print the result
        if (sol.wildCard(S1, S2))
            System.out.println("String S1 and S2 do match");
        else
            System.out.println("String S1 and S2 do not match");
	}
	

	    public boolean isAllStars(String S1, int i) {
	        for (int j = 0; j <= i; j++) {
	            if (S1.charAt(j) != '*')
	                return false;
	        }
	        return true;
	    }
	    public boolean wildcardMatchingUtil(String S1, String S2, int i, int j, int[][] dp) {
	        // Base Cases
	        if (i < 0 && j < 0)
	            return true;
	        if (i < 0 && j >= 0)
	            return false;
	        if (j < 0 && i >= 0)
	            return isAllStars(S1, i);

	        /* If the result for this state has 
	        already been calculated, return it */
	        if (dp[i][j] != -1)
	            return dp[i][j] == 1;

	        boolean result;

	        /* If the characters at the current
	        positions match or S1 has a '?' */
	        if (S1.charAt(i) == S2.charAt(j) || S1.charAt(i) == '?') {
	            result = wildcardMatchingUtil(S1, S2, i - 1, j - 1, dp);
	        } else if (S1.charAt(i) == '*') {
	            /* Two options: either '*' represents an 
	            empty string or it matches a character in S2 */
	            result = wildcardMatchingUtil(S1, S2, i - 1, j, dp) || wildcardMatchingUtil(S1, S2, i, j - 1, dp);
	        } else {
	            result = false;
	        }

	        /* Memoize the result */
	        dp[i][j] = result ? 1 : 0;
	        return result;
	    }

	    public boolean wildCard(String str, String pat) {
	        int n = str.length();
	        int m = pat.length();

	        /* Create a DP table for 
	        memoization, initialized with -1 */
	        int[][] dp = new int[n][m];
	        for (int[] row : dp) {
	            Arrays.fill(row, -1);
	        }

	        return wildcardMatchingUtil(str, pat, n - 1, m - 1, dp);
	    }
	}


