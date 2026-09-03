class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        
        return dfs(0, 0, m, n, memo);
    }

    public int dfs(int r, int c, int ROWS, int COLS, int[][] memo) {
        if(r == ROWS || c == COLS)
            return 0;

        if(memo[r][c] != 0)
            return memo[r][c];
        
        if(r == ROWS - 1 || c == COLS - 1)
            return 1;

        return memo[r][c] = dfs(r + 1, c, ROWS, COLS, memo) + dfs(r, c + 1, ROWS, COLS, memo);
    }
}
