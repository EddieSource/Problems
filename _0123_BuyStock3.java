
public class _0123_BuyStock3 {
	public int maxProfit(int[] prices) {
	    // Write your solution here
	    // assumption: given array is not null and length >= 2
		if(prices== null || prices.length <= 1) return 0; 
		// split the array to two sequence

		
		// leftProfits[i] is the most profits that one can make from [0, i] by one transaction
		int[] leftProfits = new int[prices.length];
		leftProfits[0] = 0; 
		int leftBuy = prices[0]; // buy at the lowest level
		
		// rightProfits[i] is the most profits that one can make from [i, array.length - 1] by one transaction
		int[] rightProfits = new int[prices.length]; 
		rightProfits[prices.length - 1] = 0; 
		int rightSell = prices[prices.length - 1]; 
		
		for(int i = 1; i < leftProfits.length; i++) {
			leftProfits[i] = Math.max(leftProfits[i - 1], prices[i] - leftBuy); 
			leftBuy = Math.min(leftBuy, prices[i]); 	
		}
	    
		for(int i = rightProfits.length - 2; i >= 0; i--) {
			rightProfits[i] = Math.max(rightProfits[i + 1], rightSell - prices[i]); 
			rightSell = Math.max(rightSell, prices[i]); 
		}
		
		int maxProfit = 0; 
		for(int i = 0; i < prices.length; i++) {
			maxProfit= Math.max(maxProfit,  leftProfits[i] + rightProfits[i]); 
		}
		return maxProfit; 
		

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_0123_BuyStock3 a = new _0123_BuyStock3(); 
		a.maxProfit(new int[] {1,7,3,8}); 

	}
}
