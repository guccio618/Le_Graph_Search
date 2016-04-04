import java.util.LinkedList;
import java.util.Queue;


public class Le_130_Surrounded_Regions {
	/*******************************************************************
	 * 矩阵用iterator进行bfs的方法： q里存 i * col + col
	 *  (1). 结点引入3态。
	 *  (2). 从边界入手，可以遍历到的结点改为第三态D
	 *  (3). 将第三态D的结点改为O, 将原来为O的结点改为X
	 *  
	 *******************************************************************/
	
	public void solve(char[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        int row = board.length;
        int col = board[0].length;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        for(int i = 0; i < row; ++i){
            if(board[i][0] == 'O'){
                q.offer(i * col);
            }
            if(board[i][col - 1] == 'O'){
                q.offer(i * col + col - 1);
            }
        }
        
        for(int j = 0; j < col; ++j){
            if(board[0][j] == 'O'){
                q.offer(j);
            }
            if(board[row - 1][j] == 'O'){
                q.offer((row - 1) * col + j);
            }
        }
        
        while(!q.isEmpty()){
            int temp = q.poll();
            int x = temp / col;
            int y = temp % col;
            if(board[x][y] == 'O'){
                board[x][y] = 'D';
            }
            for(int i = 0; i < 4; ++i){
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(newX >= 0 && newX < row && newY >= 0 && newY < col && board[newX][newY] == 'O'){
                    q.offer(newX * col + newY);
                }
            }
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'D'){
                	board[i][j] = 'O';
                }
                else if (board[i][j] == 'O'){
                	board[i][j] = 'X';
                }
            }
        }
    }
}
