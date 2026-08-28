class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1)  return -1;
        
        int n = grid.length;

        // int[][] visited = new visited[ROWS][COLS];
        
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {1, -1}, {1, 1}, {-1, 1}};

        int length = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                int[] pair = queue.poll();
                int r = pair[0], c = pair[1];

                if(r == n - 1 && c == n - 1)
                    return length;

                for(int[] dir : directions) {
                    int newR = r + dir[0];
                    int newC = c + dir[1];

                    if(newR < 0 || newC < 0 || newR == n || newC == n || grid[newR][newC] == 1)
                        continue;
                    
                    grid[newR][newC] = 1;
                    queue.offer(new int[]{newR, newC});
                }
            }
            
            length++;
        }

        return -1;  // unreachable statement
    }
}