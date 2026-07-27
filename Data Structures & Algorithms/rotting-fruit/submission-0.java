class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int fresh = 0;
        int time = 0;
        
        Deque<int[]> queue = new ArrayDeque<>();

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(grid[r][c] == 1)
                    fresh++;

                if(grid[r][c] == 2)
                    queue.offer(new int[]{r, c});
            }
        }


        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while(fresh > 0 && !queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                int[] pair = queue.poll();
                int r = pair[0];
                int c = pair[1];

                for(int[] dir : directions) {
                    int newRow = r + dir[0];
                    int newCol = c + dir[1];

                    if(newRow < 0 || newCol < 0 || newRow == ROWS || newCol == COLS)
                        continue;

                    if(grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[]{newRow, newCol});
                        fresh--;
                    }
                }
            }
            time++;
        }

        return fresh == 0 ? time : -1;
    }
}
