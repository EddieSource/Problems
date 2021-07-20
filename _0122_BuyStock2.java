
public class _0122_BuyStock2 {
    public int maxProfit(int[] prices) {
        // [7,1,5,3,6,4]
        /*
           valley: we buy
           peek: we sell
           
           decreasing: we dt take actions
           increasing we hold
        */
        int maxprofit = 0;
        for (int day = 1; day < prices.length; day++) {
            if (prices[day] > prices[day - 1])
                maxprofit += prices[day] - prices[day - 1];
        }
        return maxprofit;
  
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
