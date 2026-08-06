class Solution {
    public boolean exist(char[][] board, String word) {
        char start = word.charAt(0);
        int ROWS = board.length;
        int COLS = board[0].length;
        int[][] visited = new int[ROWS][COLS];

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(board[r][c] == start) {
                    if(dfs(board, r, c, 0, word))  return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, int r, int c, int i, String word) {
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length)
            return false;
        
        if(i < word.length() && board[r][c] != word.charAt(i))
            return false;

        if(i == word.length() - 1)
            return true;

        char temp = board[r][c];
        board[r][c] = '#';

        boolean found = dfs(board, r, c - 1, i + 1, word)
                        || dfs(board, r, c + 1, i + 1, word)
                        || dfs(board, r - 1, c, i + 1, word)
                        || dfs(board, r + 1, c, i + 1, word);

        board[r][c] = temp;
        
        return found;
    }
}
