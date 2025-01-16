package tuf;

import java.util.Arrays;

public class Coins {

	public static void main(String[] args) {
		 int[] coins = {1, 2, 3};
	     int amount = 7;

	     System.out.println("The total number of ways is " + minimumCoins(coins, amount));

	}
	
	    public static int  minimumCoins(int[] coins, int amount) {
	        int[][] dp = new int[coins.length][amount+1];
	        for(int[] row : dp){
	            Arrays.fill(row, -1);
	        }
	        int ans = func(coins, coins.length - 1, amount, dp);
	        if(ans >= (int) 1e9){
	            return -1;
	        }
	        return ans;
	    }

	    public static int func(int[] arr, int ind, int T, int[][] dp) {
	        if(ind ==0){
	            if(T % arr[0] == 0){
	                return T/arr[0];
	            }
	            else{
	                return (int)1e9;
	            }
	        }
	        if(dp[ind][T] != -1){
	            return dp[ind][T];
	        }

	        int notTake = 0 + func(arr, ind-1, T, dp);
	        int take = (int)1e9;
	        if(arr[ind] <= T){
	            take = 1 + func(arr, ind, T - arr[ind], dp);
	        }
	        return dp[ind][T]= Math.min(take, notTake);
	    }
	}

