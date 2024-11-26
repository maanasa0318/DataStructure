package neetcodealgo;

public class BestTimetoBuyandSellStock {

	public static void main(String[] args) {

		int[] prices = {10,1,5,6,7,1};
		int res = buyAndSell(prices);
		System.out.println(res);
	}

	private static int buyAndSell(int[] prices) {
		int left =0;
		int right =1 ;
		int maxProfit =0;
		while(right < prices.length) {
			if(prices[left] < prices[right]) {
				int profit = prices[right] - prices[left];
				maxProfit = Math.max(profit, maxProfit);
			}
			else {
				left = right;
			}
			right++;
			
			
		}
		return maxProfit;
	}

}
