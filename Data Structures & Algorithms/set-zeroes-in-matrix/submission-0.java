class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstRow = false;
        boolean firstCol = false;


        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(matrix[i][j] == 0) {
                    if(matrix[0][j] == 0) firstRow = true;
                    if(matrix[i][0] == 0) firstCol = true;

                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // make cols zero
        for(int i = 1; i < cols; i++) {
            if(matrix[0][i] == 0) {
                for(int j = 0; j < rows; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        // make rows zero
        for(int i = 1; i < rows; i++) {
            if(matrix[i][0] == 0) {
                for(int j = 0; j < cols; j++)
                    matrix[i][j] = 0;
            }
        }

        if(firstCol) {
            for(int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
        
        if(firstRow) {
            for(int i = 0; i < cols; i++)
                matrix[0][i] = 0;
        }
    }

    
}
