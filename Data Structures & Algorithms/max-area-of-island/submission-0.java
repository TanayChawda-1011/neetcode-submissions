class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int res = 0;

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(grid[r][c] == 1) {
                    res = Math.max(res, dfs(grid, r, c));
                }
            }
        }

        return res;
    }

    public int dfs(int[][] grid, int r, int c) {
        if(Math.min(r, c) < 0 || r == grid.length || c == grid[0].length || grid[r][c] == 0)
            return 0;

        grid[r][c] = 0;

        int landArea = 1;
        landArea += dfs(grid, r - 1, c);
        landArea += dfs(grid, r + 1, c);
        landArea += dfs(grid, r, c - 1);
        landArea += dfs(grid, r, c + 1);

        return landArea;
    }
}
