class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();
        int ROWS = grid.length, COLS = grid[0].length;

        int fresh = 0;

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(grid[r][c] == 1)
                    fresh++;

                if(grid[r][c] == 2)
                    queue.offer(new int[]{r, c});
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int minutes = 0;

        // The queue being non-empty doesn't mean another minute needs to pass
        // The queue contains rotten oranges, not necessarily oranges that will rot something new.
        while(fresh > 0 && !queue.isEmpty() ) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                int[] pair = queue.poll();
                int r = pair[0], c = pair[1];

                for(int[] dir : directions) {
                    int newR = r + dir[0];
                    int newC = c + dir[1];

                    if(newR < 0 || newC < 0 || newR == ROWS || newC == COLS || grid[newR][newC] == 0 || grid[newR][newC] == 2)
                        continue;

                    queue.offer(new int[]{newR, newC});
                    grid[newR][newC] = 2;
                    fresh--;
                }
            }
            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}
