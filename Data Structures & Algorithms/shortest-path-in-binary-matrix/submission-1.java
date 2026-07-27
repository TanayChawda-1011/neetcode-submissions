class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1)  return -1;

        int n = grid.length;
        int[][] visited = new int[n][n];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[2]);
        visited[0][0] = 1;

        final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        int length = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                int[] pair = queue.poll();
                int r = pair[0], c = pair[1];

                if(r == n - 1 && c == n - 1)
                    return length;

                for(int dir[] : directions) {
                    int newRow = r + dir[0];
                    int newCol = c + dir[1];

                    if(newRow < 0 || newCol < 0 || newRow == n || newCol == n || visited[newRow][newCol] == 1
                       || grid[newRow][newCol] == 1)
                        continue;
                    queue.offer(new int[]{newRow, newCol});
                    visited[newRow][newCol] = 1;
                }
            }
            length++;
        }

        return -1;
    }
}