class Solution {
    public int islandPerimeter(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int[][] visited = new int[ROWS][COLS];
        int perimeter = 0;

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(grid[r][c] == 1) {
                    perimeter += 4;

                    // ONLY CHECK UP (REMOVE twice, for both the upper cell as well as the current)
                    if((r - 1) >= 0 && grid[r - 1][c] == 1)
                        perimeter -= 2;

                    // ONLY CHECK LEFT (REMOVE twice, for both the left cell as well as the current)
                    if((c - 1) >=0 && grid[r][c - 1] == 1)
                        perimeter -=2;
                }
            }
        }

        return perimeter;
    }
}