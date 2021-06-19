
public class _0072_EditDistance {
    public int minDistance(String word1, String word2) {
        int[][] distance = new int[word1.length() + 1][word2.length() + 1]; 

        //using distance[i][j] to represent substring(0, i) and substring(0, j) 
        for(int i = 0; i <= word1.length(); i++){
          for(int j = 0; j <= word2.length(); j++){
            if(i == 0){
              distance[i][j] = j; 
            }
            else if(j == 0){
              distance[i][j] = i; 
            }
            else if(word1.charAt(i - 1) == word2.charAt(j - 1)){
              //do nothing
              distance[i][j] = distance[i - 1][j - 1]; 
            }
            else {
              //delete and insert
              distance[i][j] = Math.min(distance[i - 1][j] + 1, distance[i][j - 1] + 1); 
              //replace
              distance[i][j] = Math.min(distance[i - 1][j - 1] + 1, distance[i][j]);
            }
          }
        }
        return distance[word1.length()][word2.length()]; 
            
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
