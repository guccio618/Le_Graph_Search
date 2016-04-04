
public class Le_329_Longest_Increasing_Path_in_a_Matrix {
	/*******************************************************************
	 * 矩阵搜索题通常考虑2种辅助做法，(1). visited  (2). memoSearch
	 * 此题需要求出长度，因此用visited时间复杂度不佳，重复计算比较多；
	 * memoSearch比较适合此题，可以去除重复计算； bfs遍历
	 *  
	 *******************************************************************/
	public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return 0;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] memo = new int[row][col];
        int ans = 0;
        
        for(int i = 0; i < row; ++i){
            for(int j = 0; j < col; ++j){
                ans = Math.max(ans, memoSearch(matrix, memo, i, j));
            }
        }
        
        return ans;    
    }
    
    public int memoSearch(int[][] matrix, int[][] memo, int x, int y){
        if(memo[x][y] > 0){
            return memo[x][y];
        }
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int row = matrix.length;
        int col = matrix[0].length;
        memo[x][y] = 1;

        for(int i = 0; i < 4; ++i){
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(newX >= 0 && newX < row && newY >= 0 && newY < col && matrix[x][y] > matrix[newX][newY]){
                memo[x][y] = Math.max(memo[x][y], memoSearch(matrix, memo, newX, newY) + 1);
            }
        }
        
        return memo[x][y];
    }
}
