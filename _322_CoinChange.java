import java.util.*; 
public class _322_CoinChange {
    public static int coinChange(int[] coins, int amount) {
    	int[] fewest = new int[amount + 1];
    	//fewest[i] means that the fewest number of coins to form amount i; 
    	fewest[0] = 0; 
    	for(int cur_amount = 1; cur_amount < fewest.length; cur_amount++) {
    		fewest[cur_amount] = amount + 1; 
    	}
    	for(int i = 0; i < coins.length; i++) {
    		int cur_coin = coins[i]; 
    		for(int cur_amount = cur_coin; cur_amount <= amount; cur_amount++) {
    			fewest[cur_amount] = Math.min(fewest[cur_amount], fewest[cur_amount - cur_coin] + 1); 
    		}
    	}
    	return fewest[amount] > amount ? -1 : fewest[amount]; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int[] coins = new int[] {186,419,83,408}; 
		System.out.println(coinChange(coins, 6249)); 

	}

}
