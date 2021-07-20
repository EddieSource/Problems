
public class _0121_BuyStock1 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0; 
        // minSoFar[i] is the lowest buy price from [0, i]
        // int[] minPriceSoFar = new int[prices.length]; 
        
        // optimized for space
        int minPriceSoFar = prices[0]; 
        int globalMax = 0; 
        for(int i = 1; i < prices.length; i++) {
        	
        	// check the minSoFar[i - 1]
        	int buyPrice = minPriceSoFar; 
        	int sellPrice = prices[i]; 
        	globalMax = Math.max(globalMax, sellPrice - buyPrice); 
        	
        	if(prices[i] < minPriceSoFar) {
        		minPriceSoFar = prices[i]; 
        	}
        	
        	
        }
        
        return globalMax; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_0121_BuyStock1 a = new _0121_BuyStock1(); 
		a.maxProfit(new int[] {7,1,5,3,6,4}); 
	}

}
