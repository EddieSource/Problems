import java.util.*; 
public class _0407_TrappingRainWater2 {
    static class Pair implements Comparable<Pair>{
  int x; 
  int y; 
  int height; 

  Pair(int x, int y, int height){
    this.x = x; 
    this.y = y; 
    this.height = height; 
  }

  @Override
  public int compareTo(Pair another){
    if(this.height == another.height) return 0; 
    return this.height < another.height ? -1 : 1; 
  }
}
  
  public int trapRainWater(int[][] matrix) {
int rows = matrix.length; 
  int cols = matrix[0].length; 
  if(rows < 3 || cols < 3){
    return 0; 
  }

  // BFS, minHeap maintains all the border cells
  PriorityQueue<Pair> minHeap = new PriorityQueue<>(); 
  boolean[][] visited = new boolean[rows][cols]; 
  // put all the border cells 
  processBoarder(matrix, visited, minHeap, rows, cols); 
  
  int result = 0; 
  while(!minHeap.isEmpty()){
    Pair shortest = minHeap.poll(); 
    List<Pair> neighbors = allNeighbors(shortest, matrix, visited); 
    for(Pair nei: neighbors){
      if(visited[nei.x][nei.y]){
        continue; 
      }
      // adjust the neighbor cell's height to the current water level
      visited[nei.x][nei.y] = true; 
      // the maximum water level currently is controlled by the cur shortest cell
      result += Math.max(shortest.height - nei.height, 0); 
      nei.height = Math.max(shortest.height, nei.height); 

      minHeap.offer(nei); 
    }
  }
  return result; 
  }
  
    private void processBoarder(int[][] matrix, boolean[][] visited, PriorityQueue<Pair> minHeap, int rows, int cols){
  // start points of the whole BFS process
  // put all the border cells into the min heap at the very beginning
  for(int j = 0; j < cols; j++){
    minHeap.offer(new Pair(0, j, matrix[0][j])); 
    minHeap.offer(new Pair(rows - 1, j, matrix[rows - 1][j])); 
    visited[0][j] = true; 
    visited[rows - 1][j] = true; 
  }

  for(int i = 1; i < rows - 1; i++){
    minHeap.offer(new Pair(i, 0, matrix[i][0])); 
    minHeap.offer(new Pair(i, cols - 1, matrix[i][cols - 1])); 
    visited[i][0] = true; 
    visited[i][cols - 1] = true; 
  }
}

private List<Pair> allNeighbors(Pair cur, int[][] matrix, boolean[][] visited){
  List<Pair> neis = new ArrayList<>(); 
  if(cur.x + 1 < matrix.length){
    neis.add(new Pair(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y])); 
  }

  if(cur.x - 1 >= 0){
    neis.add(new Pair(cur.x - 1, cur.y, matrix[cur.x - 1][cur.y])); 
  }

  if(cur.y + 1 < matrix[0].length){
    neis.add(new Pair(cur.x, cur.y + 1, matrix[cur.x][cur.y + 1])); 
  }

  if(cur.y - 1 >= 0){
    neis.add(new Pair(cur.x, cur.y - 1, matrix[cur.x][cur.y - 1])); 
  }

  return neis; 
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
