class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] memo = new int[m][n];
        
        for(int[] layer : memo)
            Arrays.fill(layer, -1);
        
        return dfs(obstacleGrid, 0, 0, m, n, memo);
    }

    public int dfs(int[][] grid, int r, int c, int m, int n, int[][] memo) {
        if(r == m || c == n)
            return 0;

        if(memo[r][c] != -1)
            return memo[r][c];
        
        if(grid[r][c] == 1) {
            memo[r][c] = 0;
            return 0;
        }

        if(r == m - 1 && c == n - 1)
            return 1;

        return memo[r][c] = dfs(grid, r + 1, c, m, n, memo) + dfs(grid, r, c + 1, m, n, memo);
    }
}