/*
In a given grid, each cell can have one of three values:
the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
Example 1:
Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:
Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:
Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 Note:
1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] is only 0, 1, or 2.
*/
class Solution {
    int directions[][] = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int orangesRotting(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return -1;
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;
        int time = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0;i < n;i ++){
            for(int j = 0;j < m;j++){
                if(grid[i][j] == 2)
                    queue.offer(new int[]{i,j});
                else if(grid[i][j] == 1)
                    fresh ++;
            }
        }
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i < size ;i++){
            int bad [] = queue.poll();
            for(int dir[] : directions){
                int x = bad[0] + dir[0];
                int y = bad[1] + dir[1];
                if(x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 1){
                    grid[x][y] = 2;
                    queue.offer(new int[]{x,y});
                    fresh --;                    
                    if(fresh == 0)
                       return time + 1;
                }
            }
        }        
        time++;
        }        
        return fresh == 0? 0 : -1;
    }
}