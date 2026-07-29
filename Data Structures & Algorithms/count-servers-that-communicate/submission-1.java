class Solution {
    public int countServers(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int[] rowCount = new int[ROWS];
        int[] colCount = new int[COLS];
        int res = 0;

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(grid[r][c] == 1) {
                    rowCount[r]++;
                    colCount[c]++;
                }
            }
        }

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(grid[r][c] == 1) {
                    if(rowCount[r] > 1 || colCount[c] > 1)
                        res++;
                }
            }
        }
        
        return res;
    }
}