class Solution {
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n];
        Arrays.fill(prev, 1);

        for(int i = 0; i < m - 1; i++) {
            int[] newRow = new int[n];
            newRow[n - 1] = 1;

            for(int j = n - 2; j >= 0; j--) {
                newRow[j] = newRow[j + 1] + prev[j];
            }

            prev = newRow;
        }

        return prev[0];
    }
}
