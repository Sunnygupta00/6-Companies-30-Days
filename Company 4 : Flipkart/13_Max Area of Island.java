class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
         for(int i=0;i<n;i++){
             for(int j =0;j<m;j++){
                 if(grid[i][j] == 1){
                     int val[] = new int[1];
                     rec(grid, i, j , n, m,val );
                     count = Math.max(val[0], count);
                 }
             }
         }
        return count;        
    }
    public int dir[][] ={{1,0},{0,1},{-1,0}, {0,-1}};
    public void rec(int [][]grid, int i, int j, int n, int m, int []val){
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j] == 0){
            return ;
        }
        grid[i][j] = 0;
        val[0] +=1;
        for(int []a : dir){
            int row = a[0]+i;
            int col = a[1]+j;
            rec(grid,row, col, n, m, val);
        }
    }
}
