package slidingwindow;

public class MaxProfitFromStocks {
	
	public static int maxProfit(int[] input) {	  
		int maxProfit=0;	
		int min=input[0];

		for (int num : input) {
			min = Math.min(min, num);
			maxProfit = Math.max(maxProfit, num - min);
		}		
		return maxProfit;
	}

	public static void main(String[] args) {
		
		int [] prices = {7,1,5,3,6,4};
		System.out.println(maxProfit(prices));		
	}
}
