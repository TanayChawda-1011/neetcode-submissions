class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n + 1];

        for(int i = 0; i <= n; i++)
            dp[i] = Integer.MAX_VALUE;

        dp[n - 1] = 0;

        for(int r = m - 1; r >= 0; r--) {
            for(int c = n - 1; c >= 0; c--) {
                dp[c] = grid[r][c] + Math.min(dp[c], dp[c + 1]);
            }
        }
        

        return dp[0];
    }
}