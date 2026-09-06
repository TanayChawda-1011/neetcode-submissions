class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;   
        Integer[][] dp = new Integer[m][n];

        for(Integer[] layer : dp)
            Arrays.fill(layer, -1);

        return recursion(grid, 0, 0, m, n, dp);
    }

    public int recursion(int[][] grid, int r, int c, int m, int n, Integer[][] dp) {
        if(r == m || c == n)
            return Integer.MAX_VALUE;

        if(r == m - 1 && c == n - 1)
            return grid[r][c];

        if(dp[r][c] != -1)
            return dp[r][c];

        return dp[r][c] = grid[r][c] + Math.min(
                            recursion(grid, r + 1, c, m, n, dp), 
                            recursion(grid, r, c + 1, m, n, dp)
                        );
    }
}