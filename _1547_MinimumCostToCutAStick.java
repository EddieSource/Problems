import java.util.*; 
public class _1547_MinimumCostToCutAStick {
    public int minCost(int n, int[] cuts) {
    	Arrays.sort(cuts); 
    	int[] helper = new int[cuts.length + 2]; 
    helper[0] = 0; 
    for (int i = 0; i < cuts.length; i++) {
      helper[i + 1] = cuts[i]; 
    }
    helper[helper.length - 1] = n; 

    int[][] minCost = new int[helper.length][helper.length]; 
    // minCost represent the minimum cost of cutting the wood between i and j
    for (int i = 1; i < helper.length; i++) {
      for (int j = i - 1; j >= 0; j--) {
        if (j + 1 == i) {
          minCost[j][i] = 0; 
        }
        else {
          minCost[j][i] = Integer.MAX_VALUE; 
          for (int k = j + 1; k <= i - 1; k++) {
            minCost[j][i] = Math.min(minCost[j][i], minCost[j][k] + minCost[k][i]); 
          }
          minCost[j][i] += helper[i] - helper[j]; 
        }
      }
    }
    return minCost[0][helper.length - 1]; 

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
