class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] visited = new int[image.length][image[0].length];
        int startColor = image[sr][sc];

        if(startColor == color) return image;

        dfs(image, visited, sr, sc, startColor, color);

        return image;
    }

    public void dfs(int[][] image, int[][] visited, int R, int C, int startColor, int color) {
        if(R < 0 || C < 0 || R == image.length || C == image[0].length || visited[R][C] == 1 || image[R][C] == color || image[R][C] != startColor)
            return;

        if(image[R][C] == startColor)
            image[R][C] = color;

        visited[R][C] = 1;

        dfs(image, visited, R + 1, C, startColor, color);
        dfs(image, visited, R - 1, C, startColor, color);
        dfs(image, visited, R, C + 1, startColor, color);
        dfs(image, visited, R, C - 1, startColor, color);
    }
}