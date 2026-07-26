class Solution {    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] visited = new int[image.length][image[0].length];
        int startColor = image[sr][sc];

        dfs(image, sr, sc, color, startColor, visited);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int color, int startColor, int[][] visited) {
        int ROWS = image.length, COLS = image[0].length;

        if(Math.min(sr, sc) < 0 || sr == ROWS || sc == COLS || 
           visited[sr][sc] == 1 || image[sr][sc] == color || image[sr][sc] != startColor)
            return;
        
        visited[sr][sc] = 1;
        
        image[sr][sc] = color;
        
        dfs(image, sr - 1, sc, color, startColor, visited);
        dfs(image, sr + 1, sc, color, startColor, visited);
        dfs(image, sr, sc - 1, color, startColor, visited);
        dfs(image, sr, sc + 1, color, startColor, visited);
    }
}